package cheema.mirine.myButtons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import cheema.mirine.CalculatorLib.Token;
import cheema.mirine.R;



public class NumButton extends MyButton{

    public NumButton(){
        super(null);
        myinit();
    }

    public NumButton(Context context){
        super(context);
        myinit();
    }

    public NumButton(Context context, AttributeSet attrs){
        super(context, attrs);
        myinit();
    }

    public NumButton(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        myinit();
    }

    public void myinit(){
        super.myinit();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = getText().toString();
                TextView qusTv=(TextView) getRootView().findViewById(R.id.qusTv);
                try {
                    if( Token.lastToken(qusTv.getText().toString()).getVal().compareTo("∞")!=0){
                        qusTv.append(str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
