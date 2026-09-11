public class ConvertDataTypes 
{
    static short methodOne(long l) 
    {
        int i = (int) l;
        return (short) i;
    }
 
    public static void main(String[] args) 
    {
        double d = 10.25;
        float f = (float) d;               // f = 10.25f
        byte b = (byte) methodOne((long) f); // (long) f = 10 -> methodOne(10) -> 10 -> b = 10
        System.out.println(b); // output: 10
    }
}