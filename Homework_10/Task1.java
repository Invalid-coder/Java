package Homework_10;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.Date;
import java.util.ArrayList;

/*
 * ™ готель з N номерами. „ерез випадковий час в≥д 1 до t1 приходить
 * новий кл≥Їнт та засел€Їтьс€ у один з номер≥в (€кщо Ї в≥льний), у €кому живе
 * час в≥д 1 до t2. якщо в≥льних номер≥в немаЇ, то кл≥Їнт оч≥куЇ на зв≥льненн€
 * будь-€кого номера. ѕри заданих параметрах N, t1, t2 розрахувати середню
 * довжину черги кл≥Їнт≥в та середн≥й час оч≥куванн€.
 * ¬каз≥вка: один кл≥Їнт Ц це 1 пот≥к.
 */

class Length
{
	public int value;
}

public class Task1 {
	public static void main(String[] args) 
	{
		int N = 3;
		int n = 10;
		int t1 = 7;
		int t2 = 10;
			
		// Lock lock = new Lock();
		Semaphore lock = new Semaphore(N, true);
		ArrayList<Double> waiting_times = new ArrayList<>();
		ArrayList<Integer> queue_lengths = new ArrayList<>();
		Length length = new Length();
		length.value = 0;
		Thread[] ths = new Thread[n];
			
		for (int i = 0; i < n; i++)
		{
			long arriveTime = (long) 
					Math.floor((Math.random() * (t1 - 1) + 1) * 1000);
			long livingTime = (long) 
					Math.floor((Math.random() * (t2 - 1) + 1) * 1000);
				
			Client c = new Client(arriveTime,
					livingTime, i, lock, waiting_times, queue_lengths, length);
			ths[i] = new Thread(c, "Client " + i);
			System.out.printf("Client %d arrives at %.3f "
					+ "and lives in  room for %.3f\n",
					i, 
					(double) arriveTime / 1000,
					(double) livingTime / 1000);
			ths[i].start();
		}
		try
		{
			for (int i = 0; i < n; i++)
				ths[i].join();
		}
		catch (InterruptedException e)
		{
			System.err.println(e);
		}
		finally
		{
			double sum = 0.0;
			
			for(int i = 0; i < waiting_times.size(); i++)
			{
				System.out.print(waiting_times.get(i) + " ");
				sum += waiting_times.get(i);
			}
			System.out.println();
			double average_waiting_time = sum / waiting_times.size();
			System.out.println("Average waiting time: " + average_waiting_time);
			
			System.out.println();
			
			sum = 0.0;
			
			for(int i = 0; i < queue_lengths.size(); i++)
			{
				System.out.print(queue_lengths.get(i) + " ");
				sum += queue_lengths.get(i);
			}
			System.out.println();
			double average_queue_length = sum / queue_lengths.size();
			System.out.println("Average queue length: " + average_queue_length);
		}	
	}

}

class Client implements Runnable
{
	private long arriveTime;
	private long livingTime;
	private long waitngTime;
	private int index;
	// private Lock lock;
	private Semaphore lock;
	private ArrayList waiting_times;
	private ArrayList queue_lengths;
	private Length length;
		
	Client(long arriveTime, long transitTime,
			int index, 
			// Lock lock,
			Semaphore lock,
			ArrayList waiting_times,
			ArrayList queue_lengths,
			Length length)
	{
		this.arriveTime = arriveTime;
		this.livingTime = transitTime;
		this.index = index;
		this.lock = lock;
		this.waiting_times = waiting_times;
		this.queue_lengths = queue_lengths;
		this.length = length;
	}
		
	public void run()
	{
		try
		{
			Thread.sleep(arriveTime);
			System.out.println("Client " + index +
					" has arrived");
			long start = (new Date()).getTime();
			length.value += 1;
			queue_lengths.add(length.value);
			lock.acquire();
			double waiting_time = (((double) (new Date()).getTime() - start) / 1000);
			waiting_times.add(waiting_time);
			length.value -= 1;
			
			if (waiting_time == 0.0)
			{
				queue_lengths.remove(queue_lengths.size() - 1);
			}
			else
			{
				queue_lengths.add(length.value);
			}
			
			System.out.println("Client " + index + 
					" waited for: " +
					waiting_time +
			" seconds");
			System.out.println("Client " + index +
					" lives in room");
			Thread.sleep(livingTime);
			System.out.println("Client " + index +
					" left the room");
			lock.release();
		}
		catch (InterruptedException e) {}
		
	}
}