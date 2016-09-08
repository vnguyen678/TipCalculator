package edu.orangecoastcollege.cs273.vnguyen678.tipcalculator;

/**
 * Created by vnguyen678 on 9/8/2016.
 */
public class RestaurantBill
{
    private double mAmount;
    private double mTip;
    private double mTipAmount;
    private double mTotalAmount;

    public RestaurantBill()
    {
        mAmount = 0.0;
        mTip = 0.0;
        mTipAmount = 0.0;
        mTotalAmount = 0.0;
    }


    public RestaurantBill(double mAmount, double mTip)
    {
        this.mAmount = mAmount;
        this.mTip = mTip;
        recalculateAmounts();
    }

    public double getAmount() {
        return mAmount;
    }

    public double getTip() {
        return mTip;
    }

    public double getTipAmount()
    {
        return mTipAmount;
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmounts();;
    }

    public void setTip(double mTip) {
        this.mTip = mTip;

    }

    private  void recalculateAmounts()
    {
        mTipAmount = mAmount * mTip;
        mTotalAmount = mAmount + mTipAmount;
    }


}
