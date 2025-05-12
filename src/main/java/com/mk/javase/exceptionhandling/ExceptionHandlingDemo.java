package com.mk.javase.exceptionhandling;
/*
    Unexpected issue, built in exception present, occur issue situation
    Office
        Manager
            Staff
                Task - > occur issue -> if Staff can't fix this issue throw to Manager, Manager should handle it like catch block
    The code that can be issue write in try block
    Need to know the code issue and try catch that issue
    Need to run code even occur exception or not use finally
    finally always win
    user for clean up and close file
    Runtime Exception = Uncheck Exception ( No need to catch the Runtime Exception)
    Error (must catch) = Check Exception (try /catch)
    throw = remind occur exception
    need to focus = check exception

    Business Exception - > Prefer Check Exception
    Categorize exception (Strong and weak)
        not categorize exception -> can reversal hard
    BusinessException
        Invalid parameter
        Financial operation
        try{

        }catch(BusinessException e){
            -> Can't known the specific exception when reversal. Categorize depend in sufferers
        }
        Throw Exception when ypu can't handle the issue -> Catch Exception when you can handle the issue
        Don't catch Generic Exception
        catch(Exception e) -> catch All Exception (important and unimportant issue) eg. fire or sensor error
        Don't catch mix financial and non financial exception
        Validate Input first -> Business Logic Exception (clear own issue)
        Document the exception why occur and catch
 */
public class ExceptionHandlingDemo {
    static int div(int a, int b) throws Exception {
        if (b == 0){
            throw new Exception("Divisor is zero");
        }
        return a/b;
    }
    public static void main(String[] args) {
      /*  catch exception that throw
        try {
            int result = div(2,0); // need to catch the follow Exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       */

       /* try {
            int result = div(2,0);
            System.out.println(result);
        }catch (ArithmeticException ae){
            System.out.println(ae.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finally always win");
        }
        System.out.println("end of code");

        */
        try {
            String str = "Hello";
            System.out.println(str.toUpperCase());

            double result = 2 / 0.0;
            System.out.println(result);

            int[] arr = new int[1];
            arr[2] = 10;
            System.out.println(arr[1]);
        }catch (NullPointerException ne){ // catch (NullPointerException | ArithmeticException ne) -> Addition Exception Feature
            System.out.println("Ne found : "+ ne.getMessage());
        }catch (ArithmeticException ae){
            System.out.println("Ae found : "+ ae.getMessage());
        }catch (Exception e){
            System.out.println("E found : "+ e.getMessage()); // Generic -> E found : Index 2 out of bounds for length 2
            // should catch specific exception if catch generic Exception we don't known specify what kind of exception occur
        }
    }
}
