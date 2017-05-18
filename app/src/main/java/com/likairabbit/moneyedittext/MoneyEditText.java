package com.likairabbit.moneyedittext;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by li on 2017/5/17.
 */

public class MoneyEditText extends EditText {
    private Context ctx;
    public MoneyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx=context;
    }

public  int getValue(){
    String str = getText().toString();

    if (str.equals(""))
        return -1;
    if (str.contains(".")) {
        int a = 0;
        for (int i = str.length() - 1; i >= 0; i--) {

            char c = str.charAt(i);
            if ('.' == c) {
                if (a == 0) {
                    str = str.substring(0, i) + "00";
                } else if (a == 1) {
                    str = str.substring(0, i) + str.substring(i + 1) + "0";
                } else if (a == 2) {
                    str = str.substring(0, i) + str.substring(i + 1);
                }
            }
            a++;
        }
    } else {
        str = str + "00";
    }

    return Integer.parseInt(str);
}


    public void setChange(int a){
       setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL) ;
        setKeyListener(new DigitsKeyListener(false, true)) ;
            b=a;
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!flag) {return;}
                Message msg = Message.obtain();
                msg.obj = s.toString();
                msg.what = 1;
                handler.sendMessage(msg);
            }
        });


    }
    int b ;
    boolean flag=true;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                flag=false;
                String str = (String)msg.obj;
                if(str.contains(".")){
                    int i = str.indexOf(".");
                    if (i==0){
                        setText("0.");
                        setSelection(2);
                    }else if(str.length()-i>3){
                        String str3 = str.substring(0,str.length()-1);
                        setText(str3);
                        setSelection(str3.length());
                    }else if(Integer.parseInt(str.substring(0,i))>b){
                        Toast.makeText(ctx,"您时输入的金额过大，请重新输入",Toast.LENGTH_SHORT).show();
                        setText("");flag=true;return;
                    }

                }else{
                    if (TextUtils.isEmpty(str)){flag=true;return;}
                    int i=Integer.parseInt(str);
                    if(i>b){
                        Toast.makeText(ctx,"您时输入的金额过大，请重新输入",Toast.LENGTH_SHORT).show();
                        setText("");flag=true;return;}
                    String str2 = i+"";
                    setText(str2);
                    setSelection(str2.length());

                }


                flag=true;
            }
        }
    };

}
