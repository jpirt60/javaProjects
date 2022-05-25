package projectpt1;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
public class ProjectPt3 {

	public static void main(String[] args) throws Exception {
		//Part 3 will focus on creating parallel arrays, loading arrays from TXT files, and using a method for to do this.
		//Also finish and clean up project to turn in.	
		
		//Create variables
		String weightType = null;
		String weightLbsS = null;
		
		//P3-1 Parallel Arrays will store an unique ID and the boxer's overall boxing record to Display at the end with the other Information 
		//The array sizes are 20 to allow up to 20 entries
		String [] uniqueID = new String[20];
		String [] boxingRecord = new String[20];
		
		String weightKgS     = null;
		String heightCentiS  = null;
		String name = null;
		double weightLbs = 0;
		double weightKg      = 0.0;
		double heightCenti   = 0.0;
		String heightInchesS = null;
		double heightInches = 0;	
		double bmi = 0.0;
		int keepGoing        = 0;
		int counter          = 0;
		String uniqueIdElementP = null;
		String boxingRecordElementP = null;
		
		//Image object is created to be used and display either an healthy image or unhealthy image depending on results
		ImageIcon healthBad   = new ImageIcon("unhealthy.png");
		ImageIcon healthGreat = new ImageIcon("healthy.png");
		
		//p3-2  Load the parallel arrays with data from txt files. Using a method for this
		regId(uniqueID,"file1.txt");
		regId(boxingRecord,"file2.txt");
				
	do {
		JOptionPane.showMessageDialog(null, "Welcome to Fight for your Life! Programmed By: Jaron Pirtle - Please hit ok to continue");
		name = JOptionPane.showInputDialog("Please enter name");
		
		//The unique ID and the boxing records from the txt file belongs to the person entering the information in that order
		uniqueIdElementP = uniqueID[counter];
		boxingRecordElementP = boxingRecord[counter];
		
		//Gives user option of what type measuring system they'll be using
		weightType = JOptionPane.showInputDialog("What type of system you will use: metric or imperial ");
		
		//P3-4 String method and 3-6 Use toUpperCase()/toLowerCase() methods to simplify String inputs from users
		weightType = weightType.toUpperCase();
		
		//Error Validation Loop
		while(!weightType.equalsIgnoreCase("imperial") && !weightType.equalsIgnoreCase("metric") ) 
		{
			weightType = JOptionPane.showInputDialog("ERROR - What type of system you will use: metric or imperial ");
			//P3-4 String method and 3-6 Use toUpperCase()/toLowerCase() methods to simplify String inputs from users
			weightType = weightType.toUpperCase();
		}
		
		//Imperial measuring system is what we use in the USA so
		//if the user selects imperial system uses pounds for weight and inches for height
		if(weightType.equalsIgnoreCase("imperial"))
		{
			//This will allow user to input numerical data in the dialog boxes that can be used as numbers and not strings
			//Also the weight and the class the fighter belongs to is returned
			//There are four weight classes: Featherweight <= 130Lbs, Welterweight <= 150Lbs, LightHeavyweight <= 170Lbs, Heavyweight <= 200Lbs
			weightLbsS = JOptionPane.showInputDialog("Please enter your weight in pounds");
			weightLbs = Double.parseDouble(weightLbsS);	
			heightInchesS = JOptionPane.showInputDialog("Please enter your height in inches: ");
			heightInches = Double.parseDouble(heightInchesS);
			bmi = imperialBmiSystem(weightLbs, heightInches);
			
			if((weightLbs <= 130) && (bmi <= 25)  )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Featherweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!" );
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );		
			}
			else if((weightLbs <= 130) && (bmi >= 25)  )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Featherweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!"  );
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
			else if((weightLbs <= 150) && (bmi <= 25) )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Welterweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!" );
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
			}
			else if((weightLbs <= 150) && (bmi >= 25) )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Welterweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
			else if((weightLbs <= 170) && (bmi <= 25))
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Light Heayweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
			}
			else if((weightLbs <= 170) && (bmi >= 25))
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Light Heavyweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
			else if ((weightLbs <= 200) && (bmi <= 25))
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Heavyweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
			}
			else 
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightLbs + " Pounds. "
						+ "\nWeight Class: Heavyweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
		}
		//Metric system is what the world uses for measurements
		//So if metric is chosen the user will have to enter their weight in Kilograms and height in centimeters
		//Also the weight and the class the fighter belongs to is returned
		//There is four weight classes: Featherweight <= 60kg, Welterweight <= 70kg, LightHeavyweight <= 80kg, Heavyweight <= 90kg 
		else if(weightType.equalsIgnoreCase("metric"))
		{
			weightKgS = JOptionPane.showInputDialog("Please enter your weight in Kilograms");
			weightKg = Double.parseDouble(weightKgS);	
			
			heightCentiS = JOptionPane.showInputDialog("Please enter your height in Centimeters ");
			heightCenti = Double.parseDouble(heightCentiS);
			bmi = metricBmiSystem(weightKg, heightCenti);
			
			if((weightKg <= 60) && (bmi <= 25)  )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms "
						+ "\nWeight Class: Featherweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!" );
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
				
			}
			else if((weightKg <= 60) && (bmi >= 25)  )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms "
						+ "\nWeight Class: Featherweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
			else if((weightKg <= 70) && (bmi <= 25) )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms. "
						+ "\nWeight Class: Welterweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
			}
			else if((weightKg <= 70) && (bmi >= 25) )
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms "
						+ "\nWeight Class: Welterweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
			else if((weightKg <= 80) && (bmi <= 25))
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms. "
						+ "\nWeight Class: Light Heavyweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!" );
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
			}
			else if((weightKg <= 80) && (bmi >= 25))
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms "
						+ "\nWeight Class: Light Heavyweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
			else if ((weightKg <= 90) && (bmi <= 25))
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms. "
						+ "\nWeight Class: Heavyweight \nYour BMI is: " + bmi + "\nGreat Job! You're healthy!!!" );
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Healthy", JOptionPane.INFORMATION_MESSAGE, healthGreat );
			}
			else 
			{
				System.out.println("Boxer's Name: " + name +"\nUnique ID: " + uniqueIdElementP + "\nBoxing Record: "+ boxingRecordElementP +"\nWeight: " + weightKg + " Kilograms "
						+ "\nWeight Class: Heavyweight \nYour BMI is: " + bmi + "\nYou're BMI is too High! Let's work on that!");
				System.out.println("=================================================================================================================================");
				JOptionPane.showMessageDialog(null, "","Unhealthy", JOptionPane.INFORMATION_MESSAGE, healthBad );
			}
		}	
		keepGoing = JOptionPane.showConfirmDialog(null, "Are there anymore Boxers?");
		counter++;	
		
	}while(keepGoing == 0 );
	
	for(int i = 0; i < keepGoing; i++)
	{
		System.out.println("");
		System.out.println("");
		System.out.println("Total number of Boxers Weighed Today: " + counter);
	}
		
	}//end of main
	
	//Method is created to calculate BMI for imperial weight standards and is returned and used in main
	public static double imperialBmiSystem(double weightLbs1, double heightInches1)
	{
		//BMI is calculated and if the BMI is 26 and over they are over weight.
		double bmi1 = 0.0;
		final int BMIMULT1 = 703;
		bmi1 = (weightLbs1*BMIMULT1)/(Math.pow(heightInches1, 2));
		return bmi1;	
	}//end of method 1
	
	//Method is created to calculate BMI for imperial weight standards and is returned and used in main
	public static double metricBmiSystem(double weightKg1, double heightCenti1)
	{
		double bmi2 = 0.0;
		final int BMIMULT2 = 10000;
		bmi2 = (weightKg1)/(Math.pow(heightCenti1, 2))*BMIMULT2;
		return bmi2;
	}//end of method 2
	
	//P3-3 Method to load an array from text file 
	public static String[] regId(String[] txtList, String filename) throws Exception 
	{	
		int index = 0;	
		File fileRet = new File(filename);
		Scanner scan = new Scanner(fileRet);
		
		while(scan.hasNext())
		{
			txtList[index] = scan.nextLine();
			index++;
		}
		
		scan.close();
		return txtList;
	}//end of method
}//end of Class
