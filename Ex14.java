/**
 * Recursion & Complexity - Exercise 14
 * @author Ramy Bachayev
 * @version 16/6/2020
 */

public class Ex14
{      
    /**
     * Finds a strategy that amir wins or draw tamar in a coin game,
     * in every round one of them takes a coin from left/right edge of the array.
     * Amir is first, tamar always take the max coin.
     * Array length - minimum 2 coins, array length always even.
     * Space complexity - O(1): 7 variables, in every option in my method
     * i using a constant number of actions. 
     * Time complexity - O(n): 1 loop that giving me information about the array,
     * and in every option in my method i using max 1 loop.  
     * @param arr the inputed array with the random coins (coin>0)
     */

    public static void win (int [] arr)
    { //defining variables: 
        int amir=0, tamar=0, left=0, sumAmir=0, sumTamar=0;        
        int right=arr.length-1;
        boolean equals=true;

        for(int j=0;j+1<arr.length;j++)//check if all coins in array are equals                    
            if(arr[j]!=arr[j+1])
            {//if there's at least 1 coin with different value - coins in array not equals
                equals=false;
                break;
            }            

        //if(amir==0) - means amir didn't play his turn yet
        //if(tamar==0) - means tamar didn't play her turn yet

        if((arr.length>2)&&(equals==false))//if coins are different and there's more than 2 coins       
            for(int i=0;right>left;i++)
            {//loop works only when the right edge in array is bigger than left edge in array
                amir=0;
                tamar=0;

                if(arr[left]!=arr[right])//when 2 coin edges not equal
                {
                    //check which coin edge is bigger and check if sum of coin edge and coin in next pointer of another edge is 
                    //equal or bigger/smaller than sum of another coin edge and coin in next pointer of this edge 
                    if((arr[left]>arr[right])&&(arr[left]+arr[right-1]>arr[right]+arr[left+1]))  
                    {
                        amir=arr[left];
                        left++;
                    }
                    if((arr[left]>arr[right])&&(arr[left]+arr[right-1]==arr[right]+arr[left+1])&&(amir==0))  
                    {
                        amir=arr[left];
                        left++;
                    }
                    if((arr[left]>arr[right])&&(arr[left]+arr[right-1]<arr[right]+arr[left+1])&&(amir==0))  
                    {
                        amir=arr[right];
                        right--;
                    }
                    if((arr[right]>arr[left])&&(arr[left]+arr[right-1]<arr[right]+arr[left+1])&&(amir==0))  
                    {
                        amir=arr[right];
                        right--;
                    }
                    if((arr[right]>arr[left])&&(arr[left]+arr[right-1]>arr[right]+arr[left+1])&&(amir==0))  
                    {
                        amir=arr[left];
                        left++;
                    }
                    if((arr[right]>arr[left])&&(arr[left]+arr[right-1]==arr[right]+arr[left+1])&&(amir==0))  
                    {
                        amir=arr[right];
                        right--;
                    }
                }
                //when 2 coin edges equals
                if((arr[left]==arr[right])&&(amir==0))
                {//check if 2 edge pointers +/-2 not exceed the array limit
                    if(right-2>0&&left+2<arr.length)
                    {
                        if(arr[right-2]==arr[left+2])//check if coin in pointer +/-2 edges are equal
                        {//check which coin in next pointer edges is bigger
                            if(arr[right-1]>arr[left+1])    
                            {
                                amir=arr[left];
                                left++;    
                            }
                            if((arr[right-1]<arr[left+1])&&(amir==0))    
                            {
                                amir=arr[right];
                                right--;    
                            }                       
                        }
                        //check which coin in pointer +/-2 edge is bigger
                        if((arr[right-2]>arr[left+2])&&(amir==0))
                        {//check which coin in next pointer edges is bigger
                            if(arr[right-1]>arr[left+1])    
                            {//check if coin in next pointers edges equals or bigger/smaller than the sum of coins in pointer and pointer +/-2 edges
                                if(arr[right]+arr[right-2]>arr[right-1])
                                {
                                    amir=arr[right];
                                    right--; 
                                }
                                if((arr[right]+arr[right-2]<arr[right-1])&&(amir==0))
                                {
                                    amir=arr[left];
                                    left++; 
                                }
                                if((arr[right]+arr[right-2]==arr[right-1])&&(amir==0))
                                {
                                    amir=arr[left];
                                    left++; 
                                }
                            }
                            //check which coin in next pointer edges is bigger
                            if((arr[right-1]<arr[left+1])&&(amir==0))    
                            {//check if coin in next pointers edges equals or bigger/smaller than the sum of coins in pointer and pointer +/-2 edges
                                if(arr[left]+arr[left+2]>arr[left+1])
                                {
                                    amir=arr[left];
                                    left++; 
                                }
                                if((arr[left]+arr[left+2]<arr[left+1])&&(amir==0))
                                {
                                    amir=arr[right];
                                    right--; 
                                }
                                if((arr[left]+arr[left+2]==arr[left+1])&&(amir==0))
                                {
                                    amir=arr[right];
                                    right--; 
                                }
                            }                        
                        }
                        //check which coin in pointer +/-2 edge is bigger
                        if((arr[right-2]<arr[left+2])&&(amir==0))
                        {//check which coin in next pointer edges is bigger
                            if(arr[right-1]>arr[left+1])    
                            {//check if coin in next pointers edges equals or bigger/smaller than the sum of coins in pointer and pointer +/-2 edges
                                if(arr[right]+arr[right-2]>arr[right-1])
                                {
                                    amir=arr[left];
                                    left++; 
                                }
                                if((arr[right]+arr[right-2]<arr[right-1])&&(amir==0))
                                {
                                    amir=arr[left];
                                    left++; 
                                }
                                if((arr[right]+arr[right-2]==arr[right-1])&&(amir==0))
                                {
                                    amir=arr[left];
                                    left++; 
                                }
                            }
                            //check which coin in next pointer edges is bigger
                            if((arr[right-1]<arr[left+1])&&(amir==0))    
                            {//check if coin in next pointers edges equals or bigger/smaller than the sum of coins in pointer and pointer +/-2 edges
                                if(arr[left]+arr[left+2]>arr[left+1])
                                {
                                    amir=arr[right];
                                    right--; 
                                }
                                if((arr[left]+arr[left+2]<arr[left+1])&&(amir==0))
                                {
                                    amir=arr[right];
                                    right--; 
                                }
                                if((arr[left]+arr[left+2]==arr[left+1])&&(amir==0))
                                {
                                    amir=arr[right];
                                    right--; 
                                }
                            }                      
                        }
                        //check if coin in next pointers edges equal to sum of coins in pointer and pointer +/-2 edges
                        if(((arr[left]+arr[left+2]==arr[left+1])||(arr[right]+arr[right-2]==arr[right-1]))&&(amir==0))
                        { 
                            if(arr[right-1]==arr[left+1])//check if coins in next pointers edges equal
                            {//check if coin in next pointers edges bigger/smaller than the sum of coins in pointer and pointer +/-2 edges
                                if((arr[left]+arr[left+2]>arr[left+1])||(arr[right]+arr[right-2]<arr[right-1]))
                                {
                                    amir=arr[left];
                                    left++;
                                }
                                if(((arr[left]+arr[left+2]<arr[left+1])||(arr[right]+arr[right-2]>arr[right-1]))&&(amir==0))
                                {
                                    amir=arr[right];
                                    right--;
                                } 
                            }
                        }
                    }
                    //check if coin in pointer+1 and pointer-1 edges equals
                    if((arr[right-1]==arr[left+1])&&(amir==0))
                    {
                        amir=arr[left];
                        left++;
                    }
                }

                if(left==right)//if 2 edge pointers equal so the game is over
                    tamar=arr[left];

                if(left!=right)//if 2 edge pointers different so the game still run
                {
                    if(arr[left]!=arr[right])//when 2 coin edges not equal
                    {//checks which coin edge is bigger
                        if(arr[left]>arr[right])
                        {
                            tamar=arr[left];
                            left++;
                        }
                        if((arr[left]<arr[right])&&(tamar==0))
                        {
                            tamar=arr[right];
                            right--;
                        }
                    }
                    //when 2 coin edges equals
                    if((arr[left]==arr[right])&&(tamar==0))
                    {   
                        tamar=arr[left]; 
                        left++;
                    }
                }
                sumAmir+=amir;
                sumTamar+=tamar;
                System.out.println("Amir took: "+amir+"\nTamar took: "+tamar);
            }

        if((arr.length==2)&&(equals==false))
        {//minimum case - 2 coins that not equals            
            amir= Math.max(arr[0],arr[1]);

            if(amir==arr[0])
                tamar=arr[1];

            if(amir==arr[1])
                tamar=arr[0];

            sumAmir+=amir;
            sumTamar+=tamar; 
            System.out.println("Amir took: "+amir+"\nTamar took: "+tamar);
        } 

        if(equals==true)//if all coins in array equals
            for(int k=0;k<arr.length;k++)
            {
                amir=arr[k];
                k++;        
                tamar=arr[k];
                sumAmir+=amir;
                sumTamar+=tamar; 
                System.out.println("Amir took: "+amir+"\nTamar took: "+tamar);
            }

        if(arr.length>2)//if there's more than 2 coins in array
            System.out.println("\nFinal Score:\n"+"Amir: "+sumAmir+"\nTamar: "+sumTamar);

        if(sumAmir==sumTamar)
            System.out.println("It's a Draw!");

        if(sumAmir>sumTamar)
            System.out.println("Amir won!");

        if(sumAmir<sumTamar)
            System.out.println("Tamar won!");       
    }

    /**
     * Finds the max multiply between 3 numbers in the inputed array,
     * and print this numbers.
     * Array length - minimum 3 numbers.
     * Space complexity - O(1): 13 variables, in every option in my method
     * i using a constant number of actions. 
     * Time complexity - O(n): 1 loop that giving me information about the array except in minimum case,
     * and in every option in my method i using max 3 loops (not nesting loops). 
     * @param arr the inputed array with the random integer numbers
     * @return the max multiply of 3 numbers in the array 
     */

    public static int findTriplet (int [] arr)
    { //defining variables:        
        int num1=0, num2=0, num3=0, negative=0, positive=0, x=0, y=0;
        int count1=-1, count2=-1, max=arr[0], min=arr[0], countMax=0, countMin=0;

        if(arr.length==3)//minimum case - 3 numbers in the array
        {
            num1=arr[0];
            num2=arr[1];
            num3=arr[2];
            System.out.println("The numbers are: "+num1+" "+num2+" "+num3);
            return (num1*num2*num3); 
        }  

        for(int i=0;i<arr.length;i++)//gets data from the array
        {  
            if(max==arr[i]&&i!=0)//check if there's a same max number in array and how many
                x++; 

            if(max<arr[i])//gets the max number in the array
            {
                max=arr[i];
                countMax=i;//gets the location of the max number in the array
            }

            if(min==arr[i]&&i!=0)//check if there's a same min number in array and how many
                y++;

            if(min>arr[i])//gets the min number in the array
            {
                min=arr[i];
                countMin=i;//gets the location of the min number in the array
            }                                    

            if(arr[i]>0)//gets the total positive numbers in the array
                positive++;

            if(arr[i]<0)//gets the total negative numbers in the array
                negative++;                                 
        }

        if(negative<2)//when there's only one negative number in array
        {//multiply must be without negative number

            num1=max;//gets the max number in the array

            for(int i=0;i<arr.length;i++)//gets the 2nd max number in the array             
            //checks if number in "i" location in array is 2nd max number and checks
            //if the number is different from num1   
                if(num2<arr[i]&&i!=countMax)            
                {    
                    num2=arr[i]; 
                    count2=i;//gets the location of num2 in the array
                }

            for(int i=0;i<arr.length;i++)//gets the 3rd max number in the array 
            //checks if number in "i" location in array is 3rd max number and checks
            //if the number is different from num1+num2 
                if(num3<arr[i]&&countMax!=i&&count2!=i)               
                    num3=arr[i]; 

            System.out.println("The numbers are: "+num1+" "+num2+" "+num3);
            return (num1*num2*num3);        
        } 

        if(positive==1)//when there's only one positive number in array
        {//multiply must be with the only positive number

            num1=min;//gets the min number in the array
            num3=max;//gets the max number (positive) in the array

            for(int i=0;i<arr.length;i++)//gets the 2nd min number in the array             
            //checks if number in "i" location in array is 2nd min number and checks
            //if the number is different from num1 
                if(num2>arr[i]&&i!=countMin)                                
                    num2=arr[i];                  

            System.out.println("The numbers are: "+num1+" "+num2+" "+num3);
            return (num1*num2*num3);        
        }

        if(positive==0)//when there's only negative numbers in array
        {//multiply must be with lowest numbers for maximum multiply

            num1=max;//gets the max number in the array

            //num2 and num3 get the min number in the array for comparison
            num2=min;
            num3=min;

            for(int i=0;i<arr.length;i++)//gets the 2nd max number in the array             
            //checks if number in "i" location in array is 2nd max number and checks
            //if the number is different from num1 
                if(num2<arr[i]&&i!=countMax)            
                {    
                    num2=arr[i]; 
                    count2=i;//gets the location of num2 in the array
                } 

            for(int i=0;i<arr.length;i++)//gets the 3rd max number in the array                                
            //checks if number in "i" location in array is 3rd max number and checks
            //if the number is different from num1+num2    
                if(num3<arr[i]&&countMax!=i&&count2!=i)               
                    num3=arr[i];  

            System.out.println("The numbers are: "+num1+" "+num2+" "+num3);
            return (num1*num2*num3);        
        }

        if(negative>1&&positive>1)//when there's mixed numbers in array
        {//multiply must be the maximum multiply

            if(Math.abs(min)>max)
            {//num1 gets the min number in the array if abs(min)>max
                num1=min;
                count1=countMin;//gets the location of num1 in the array
            }

            if(Math.abs(min)<=max)
            {//num1 gets the max number in the array if abs(min)<=max
                num1=max;
                count1=countMax;//gets the location of num1 in the array
            }            

            //gets the 2nd max or min number in the array depends on num1           
            //check if there's a same max or min numbers in array, if there's more
            //min numbers than max numbers or there's 2 same min and max numbers

            int c=0;//counter loop for array 

            if((x==1&&y==1)||y>x)
            {
                //checks the max multiply between 3 numbers in array 
                if(Math.abs(max*max*min)>Math.abs(min*min*max))
                {   
                    num2=min;

                    for(;c<arr.length;c++)
                        if(count1!=countMin)//check if location of num2 different from num1 
                        {
                            count2=countMin;//gets the location of num2 in the array
                            break;
                        }
                }

                if(Math.abs(max*max*min)<Math.abs(min*min*max))
                {   
                    num2=max;

                    for(;c<arr.length;c++)
                        if(count1!=countMax)//check if location of num2 different from num1
                        {
                            count2=countMax;//gets the location of num2 in the array
                            break;
                        }
                }
            }                                             

            //num2 gets min or max number depends on num1
            if(num2==0&&count2==-1)//if num2 didn't change from beginning
            {
                if(num1==min)
                {
                    num2=max;
                    count2=countMax;//gets the location of num2 in the array                    
                } 

                if(num1==max)
                {
                    num2=min; 
                    count2=countMin;//gets the location of num2 in the array
                }
            }

            //check if num1 + num2 positive or negative, then num3 must be positive
            if((num1>0&&num2>0)||(num1<0&&num2<0))
                for(int i=0;i<arr.length;i++)
                //checks if number in "i" location in array is 3rd max number and checks
                //if the number is different from num1+num2 and bigger than 0 
                    if(num3<arr[i]&&arr[i]>0&&count1!=i&&count2!=i)               
                        num3=arr[i];

            //check if num1 or num2 negative, then num3 must be negative            
            if((num1<0&&num2>0)||(num1>0&&num2<0))
                for(int i=0;i<arr.length;i++)
                //checks if number in "i" location in array is 3rd min number and checks
                //if the number is different from num1+num2 and below 0
                    if(num3>arr[i]&&arr[i]<0&&count1!=i&&count2!=i)   
                        num3=arr[i];
        } 
        System.out.println("The numbers are: "+num1+" "+num2+" "+num3);
        return (num1*num2*num3);
    }

    /**
     * The method count how many times pattern appears in str. 
     * Pattern isn't empty (pattern!=""&&pattern!=null).
     * The method must be written only with these 2 String methods: charAt() and length().
     * The method must be recursive without loops at all!
     * @param str the inputed string 
     * @param pattern the inputed string i want to find in str
     * @return the number of times pattern appears in str 
     */

    public static int count (String str, String pattern)
    {        
        return count (str,pattern,0,0);//using overloading                
    }    

    //str- the inputed string ,pattern- the inputed string i want to find in str,
    //s- str index(start in 0), p- pattern index(start in 0)
    private static int count(String str, String pattern, int s, int p) 
    {   
        //check if pattern index=pattern length
        //(return 1 to the recursion and checks the next pattern that appears in str)
        if (p==pattern.length()) 
            return 1; 

        //check if str index=str length (return 0 to the recursion and end him) 
        if (s==str.length())
            return 0; 

        //check if char at str index=char at pattern index        
        if (str.charAt(s)==pattern.charAt(p)) 
        //return count of str index+1 and pattern index+1 to the recursion + 
        //count of str index+1 (while pattern index doesn't change) to the recursion        
            return count(str,pattern,s+1,p+1) + count(str,pattern,s+1,p); 

        //return count of str index+1 (while pattern index doesn't change) to the recursion
        return count(str,pattern,s+1,p); 
    }

    /**
     * Finds the min steps from prince roof to bad guy roof.
     * The prince can climb only up to 1 floor roof and climb down only up to 2 floor roof.
     * The prince can go only left/right/up/down (of course only in array boundaries).
     * If the bad guy in next roof, the prince can jump to him no matter which floor the prince is.
     * All numbers in array are positive except one (bad guy roof: -1).
     * If the prince can't find the bad guy the solution will be -1.
     * Number of columns in array = number of rows in array.
     * The method must be recursive without loops at all!
     * @param drm the inputed array with the "roof map"
     * @param i the inputed array row prince start (-1<i<drm.length)
     * @param j the inputed array column prince start (-1<j<drm.length)
     * @return the min steps from prince roof to bad guy roof
     */

    public static int prince(int[][] drm, int i, int j)
    {
        return prince(drm,i,j,1,drm[i][j]);//using overloading
    }

    //drm- the array, i- array row prince start, j- array column prince start,
    //sum- number of steps between roofs (default- 1), real- prince roof start point
    private static int prince(int[][] drm, int i, int j, int sum, int real)   
    {
        //check the array boundaries or if the prince was in this roof
        if(i<0||j<0||i>=drm.length||j>=drm.length||drm[i][j]==-10)
            return -1;

        if(drm[i][j]==-1)//check if the prince in bad guy roof
            return sum;       

        //check if next roof above 1 floor or below 2 floors                
        if(real-drm[i][j]>2||real-drm[i][j]<-1) 
            return -1;

        //i,j+1 - right
        //i,j-1 - left
        //i+1,j - down
        //i-1,j - up                

        if(i+1<drm.length)//check the array boundaries
            if(drm[i+1][j]==-1)//check if bad guy in next roof
                return sum+1;

        if(i-1>-1)//check the array boundaries
            if(drm[i-1][j]==-1)//check if bad guy in next roof
                return sum+1;

        if(j-1>-1)//check the array boundaries
            if(drm[i][j-1]==-1)//check if bad guy in next roof
                return sum+1;

        if(j+1<drm.length)//check the array boundaries
            if(drm[i][j+1]==-1)//check if bad guy in next roof
                return sum+1;                   

        if(sum!=1)//temp already defined in this method while sum is default         
            real=drm[i][j];

        drm[i][j]=-10;//this roof get a sign that the prince was here        

        //gets the min number of steps to the bad guy from prince start point
        int move=min(prince(drm,i,j+1,sum+1,real),prince(drm,i,j-1,sum+1,real),
                prince(drm,i+1,j,sum+1,real),prince(drm,i-1,j,sum+1,real));                                        

        drm[i][j]=real;//this roof gets the true floor value that it was

        return move;//calling recursion to choose which way go        
    }     

    private static int min(int a, int b, int c, int d)
    {
        //this method gets the min positive number of steps from prince start point
        //to bad guy roof, if there isn't solution the return will be -1

        int min=a;//can be only >=-1  

        if(min<0||(b>0&&b<min))//check min positivity
            min=b;

        if(min<0||(c>0&&c<min))//check min positivity        
            min=c;

        if(min<0||(d>0&&d<min))//check min positivity        
            min=d;

        return min;//returns the min steps    
    }    
}