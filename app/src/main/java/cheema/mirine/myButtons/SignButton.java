package cheema.mirine.myButtons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cheema.mirine.CalculatorLib.Token;
import cheema.mirine.R;



public class SignButton extends MyButton{
    public SignButton(Context context) {
        super(context);
        myinit();
    }

    public SignButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        myinit();
    }

    public SignButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        myinit();
    }

    public void myinit(){
        super.myinit();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = getText().toString();
                TextView qusTv=(TextView) getRootView().findViewById(R.id.qusTv);
                String qusStr = qusTv.getText().toString();
                if(qusStr.length()==0) {
                    if (str.charAt(0) == '-') {
                        qusTv.append(str);
                    }
                }
                else if(qusStr.length()==1){
                    if(qusStr.charAt(0)!='-' && qusStr.charAt(0)!='.' && qusStr.charAt(0)!='∞'){
                        qusTv.append(str);
                    }
                }
                else{
                    if(Token.isSym(qusStr.charAt(qusStr.length()-1))){
                        if(Token.isSym(qusStr.charAt(qusStr.length()-2))){

                        }else{
                            if(str.charAt(0)=='-'){
                                qusTv.append(str);
                            }
                        }
                    }
                    else{
                        try {
                            int i=Token.lastToken(qusStr).getVal().compareTo(".");
                            int j=Token.lastToken(qusStr).getVal().compareTo("-.");
                            if(i!=0 && j!=0) {
                               // Toast.makeText(getContext(), "if "+Token.lastToken(qusStr).getVal()+ " : " + i, Toast.LENGTH_SHORT).show();
                                qusTv.append(str);
                            }
                            else {
                            //    Toast.makeText(getContext(), "else "+Token.lastToken(qusStr).getVal()+ " : " + i, Toast.LENGTH_SHORT).show();

                            }
                        } catch (Exception e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }//end method
        });
    }
}
