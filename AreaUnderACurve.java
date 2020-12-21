import java.util.Scanner;
import java.lang.Math;
public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
	    Interval first = new Interval(a,b);
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(first);
        double area = computeSubArea(first.getStart(), first.getEnd());
        double new_area = 0;
        while (true){
            Interval cur = pq.remove_max();
            double end = cur.getEnd();
            double start = cur.getStart();
            double mid = (start + end) / 2;
            new_area = area - computeSubArea(start, end) + computeSubArea(start, mid) + computeSubArea(mid, end);          
            pq.insert(new Interval(start, mid));
            pq.insert(new Interval(mid, end));
            //System.out.println(new_area);
            //System.out.println(Math.abs(area - new_area));
            if (Math.abs(area - new_area) < error)
                break;
            area = new_area;
        }
		return area; // Remove this statement and return the computed area.
	}

    private static double computeSubArea(double start, double end){
        return (end - start) * f(end); 
    }

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
