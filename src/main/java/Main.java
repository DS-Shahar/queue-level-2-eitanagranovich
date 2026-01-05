
import java.util.*;
public class Main {

	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.insert("c");
		q.insert("c");
		q.insert("a");
		q.insert("c");

		Queue<Integer> q1 = new Queue<>();
		q1.insert(11);
		q1.insert(33);
		q1.insert(2);
		q1.insert(33);
		Queue<Integer> q1Copy = copyQueueInt(q1);

		System.out.println("ex1:");
		Queue<Integer> ex1Q = ex1(q);
		System.out.println(ex1Q.toString());
		System.out.println("ex2:" + ex2(q));
		System.out.println("ex3:" + ex3(q1Copy));
		q1Copy = copyQueueInt(q1);
		System.out.println("ex4:" + ex4(q1Copy));
        System.out.println("max:" + findMax(q1));
        System.out.println("num of digits:" + numOfDigits(4567));
        System.out.println("num of place(ex3):" + placeOfNum(1234, 0));
		
	}

	public static Queue<Integer> ex1(Queue<String> q) {
		Queue<String> qCopy = copyQueueStr(q);
		Queue<Integer> c = new Queue<>();
		int count = 1;
		String current;
		String prev = null;

		while (!qCopy.isEmpty()) {
			current = qCopy.remove();
			if (current.equals(prev)) {
				count++;
			} else {
				if (prev != null) {
					c.insert(count);
				}
				count = 1;
			}
			prev = current;
		}
		c.insert(count);

		return c;
	}


	public static boolean ex2(Queue<String> q) {
		Queue<String> qCopy = copyQueueStr(q);
		Queue<String> qHelp = new Queue<>();
		String str;
		boolean bool;
		while(!qCopy.isEmpty()) {
			str = qCopy.remove();
			bool = isInStr(qHelp, str);
			if (bool) {
				return true;
			}
			qHelp.insert(str);

		}
		return false;
	}


	public static Queue<Integer> ex3(Queue<Integer> q) {
		Queue<Integer> result = new Queue<>();
		Set<Integer> seen = new HashSet<>();

		while (!q.isEmpty()) {
			int current = q.remove();
			if (!seen.contains(current)) {
				result.insert(current);
				seen.add(current);
			}
		}

		return result;
	}


	public static Queue<Integer> ex4(Queue<Integer> q) {
		Queue<Integer> sortedQueue = new Queue<>();
		Queue<Integer> tempQueue = new Queue<>();

		while (!q.isEmpty()) {
			int min = q.remove();

			while (!q.isEmpty()) {
				int current = q.remove();
				if (current < min) {
					tempQueue.insert(min);
					min = current;
				} else {
					tempQueue.insert(current);
				}
			}

			sortedQueue.insert(min);

			while (!tempQueue.isEmpty()) {
				q.insert(tempQueue.remove());
			}
		}

		return sortedQueue;
	}



	public static Queue<Integer> copyQueueInt(Queue<Integer> q) {
		Queue<Integer> qNew = new Queue<>();
		Queue<Integer> temp = new Queue<>();

		while(!q.isEmpty()) {
			int num = q.remove();
			qNew.insert(num);
			temp.insert(num);
		}

		while(!temp.isEmpty()) {
			q.insert(temp.remove());
		}

		return qNew;
	}

	public static Queue<String> copyQueueStr(Queue<String> q) {
		Queue<String> qNew = new Queue<>();
		Queue<String> temp = new Queue<>();

		while(!q.isEmpty()) {
			String num = q.remove();
			qNew.insert(num);
			temp.insert(num);
		}

		while(!temp.isEmpty()) {
			q.insert(temp.remove());
		}

		return qNew;
	}

	public static boolean isInStr(Queue<String> q, String num) {
		Queue<String> qCopy = copyQueueStr(q);
		int count = 0;
		while(!qCopy.isEmpty()) {
			if (qCopy.remove() == num) {
				count++;
			} else {
				count = 0;
			}
			if (count > 1) {
				return true;
			}
		}
		return false;
	}

	public static int findMax(Queue<Integer> q) {
		Queue<Integer> qCopy = copyQueueInt(q);
		int max = 0;
		int num;
		while(!qCopy.isEmpty()) {
			num = qCopy.remove();
			if (num > max) {
				max = num;
			}
		}

		return max;
	}
	
	public static int numOfDigits(int num){
	    int result = (int)Math.log10(num) + 1;
	    return result;
	}
	
    public static int placeOfNum(int num, int place){
        for (int i = 0; i < place; i++) {
            num = num / 10;
        }
        return (num % 10);
    }


}
