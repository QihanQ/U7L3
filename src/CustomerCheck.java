import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double p = 0;
        for(int n = 0; n < check.size(); n++)
        {
            p += check.get(n).getPrice();
        }
        return p;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        if(totalPrices() < 40)
        {
            return false;
        }
        for(int n = 0; n < check.size(); n++)
        {
            if(check.get(n).isDailySpecial())
            {
                return false;
            }
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double pay = totalPrices();
        int customers = 0;
        for(int n = 0; n < check.size(); n++)
        {
            if (check.get(n).isEntree())
            {
                customers++;
            }
        }
        if(customers >= 6)
        {
            pay = 1.2 * pay;
        }

        if(couponApplies())
        {
            pay = pay - totalPrices() * 0.25;
        }
        return pay;
    }
}