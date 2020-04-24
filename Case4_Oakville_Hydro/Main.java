import java.io.*;

public class Main {
	public static void main (String[] args) throws IOException{
		String line;
		int sum = 0;
		int m=1;
		int n=0;
		int [] data =new int[100];
		BufferedReader fin = new BufferedReader(new FileReader("test.txt"));
		line=fin.readLine();
		int req = Integer.parseInt(line);
		if (req==8755 || req==10946 || req==14740)
		{	
			do{
				line=fin.readLine();
				if (line!=null)
				{	
					if (m == 366)
					{
						data[n]=sum;
						m = 1 ;
						n++;
						sum=0;
					}
					int i = Integer.parseInt(line);	
					if (i > req)
						sum ++;
					m++;
					if (n == 99)
					{
						data[n]=sum;
					}
				}
			}while (line!=null);
		}
		else
		{
			int oldreq = req+1855;
			int tank = 1855;
			do{
				line=fin.readLine();
				if (line!=null)
				{	
					if (m == 366)
					{
						data[n]=sum;
						m = 1 ;
						n++;
						sum=0;
						tank=1855;
					}
					int i = Integer.parseInt(line);	
					if (i > oldreq)
					{
						sum ++;
						if (tank!=1855)
						{
							if (tank+i-oldreq>1855)
								tank=1855;
							else
								tank=tank+i-oldreq;
						}
					}
					else
					{
						if (i+tank>oldreq)
						{
							sum++;
							tank = i+tank-oldreq;
						}
						else
							tank=1855;
					}
					m++;
					if (n == 99)
					{
						data[n]=sum;
					}
				}
			}while (line!=null);
		}
		
		
		fin.close();
		for (int j=0;j<100;j++)
			System.out.println(data[j]);
	}

}
