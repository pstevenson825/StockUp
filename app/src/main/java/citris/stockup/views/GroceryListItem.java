package citris.stockup.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import citris.stockup.grocerylist.ViewGroceriesActivity.*;

import citris.stockup.R;
import citris.stockup.groceries.Grocery;

/**
 * Created by Panic on 4/6/2015.
 */

public class GroceryListItem extends LinearLayout {

    private Grocery grocery;
    private CheckedTextView checkbox;
    private TextView subtext;
    private TextView color;
    private android.graphics.Typeface tf;
    private TextView check;
    private TextView delete;

    public GroceryListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        //tf.createFromAsset(context.getAssets(), "Roboto-Black.ttf");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        checkbox = (CheckedTextView)findViewById(android.R.id.text1);
        subtext = (TextView)findViewById(android.R.id.text2);
        color = (TextView) findViewById(R.id.bar);
        delete = (TextView)findViewById(R.id.delete_button);
        check = (TextView) findViewById(R.id.check);
    }

    public Grocery getGrocery() {
        return grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
        if (grocery.getTTL() <= 3) {
            color.setBackgroundColor(0xFFFF4444);
        } else if (grocery.getTTL() <= 6) {
            color.setBackgroundColor(0xffffff00);
        } else {
            color.setBackgroundColor(0xff0e8022);
        }
        //checkbox.setTypeface(tf);
        checkbox.setText(grocery.getName());
        if (grocery.isComplete()) {
            check.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
        }
        delete.setVisibility(View.INVISIBLE);
        if(grocery.getDelete()) {
            delete.setVisibility(View.VISIBLE);
        }
        subtext.setText("" + grocery.getBrand() + " - " + grocery.getQuantityInt() + " " + grocery.getQuantityType());
    }
}