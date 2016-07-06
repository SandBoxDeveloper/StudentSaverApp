package com.charlesmolyneux.studentsaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by charlesmolyneux on 04/07/2016.
 */
public class PaymentListViewAdapter extends BaseAdapter {
    ArrayList<PaymentClass> paymentClass;

    Context context;

    private static LayoutInflater inflater=null;

    public PaymentListViewAdapter(Context context, ArrayList<PaymentClass> payment) {
        paymentClass = payment;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class Holder {
        TextView paymentLabel;
        TextView paymentAmountLabel;
        ImageView paymentCategoryImage;
    }

    @Override
    public int getCount() {
        return paymentClass.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.payments_list, null);

            holder.paymentLabel = (TextView) rowView.findViewById(R.id.payment_label_tv);
            holder.paymentAmountLabel = (TextView) rowView.findViewById(R.id.payment_amount_tv);
            holder.paymentCategoryImage = (ImageView) rowView.findViewById(R.id.p_category_iv);

            holder.paymentLabel.setText(paymentClass.get(position).getPaymentCategory());

             String amount = paymentClass.get(position).getPaymentType();
            if (Objects.equals(amount, "Expense")) {
                holder.paymentAmountLabel.setText("-£" + paymentClass.get(position).getPaymentAmount());
             //   holder.paymentAmountLabel.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));
            } else {
                holder.paymentAmountLabel.setText(" £" + paymentClass.get(position).getPaymentAmount());
             //   holder.paymentAmountLabel.setTextColor(context.getResources().getColor(android.R.color.holo_green_light));

            }


            holder.paymentCategoryImage.setImageResource(R.drawable.pay_day_image);

        return rowView;

    }
}
