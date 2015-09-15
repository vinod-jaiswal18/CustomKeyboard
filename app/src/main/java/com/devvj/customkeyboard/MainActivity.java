package com.devvj.customkeyboard;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "[MainActivity]";
    private static String tp_seq = "", token_id = "";
    final int PIN_LENGTH = 6;

    EditText etVerificationCode;
    Toolbar toolbar;

    TextView tvVerificationText;

    Button button0;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    ImageButton buttonClear;
    ImageButton buttonProceed;
    private String verificationCode = "";
    private String userEntered = "";


    private ToneGenerator toneGeneratorKeypad;


    private View.OnTouchListener otl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.def_toolbar);
        etVerificationCode = (EditText)findViewById(R.id.etVerificationCode);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        buttonClear = (ImageButton)findViewById(R.id.buttonClear);
        buttonProceed = (ImageButton)findViewById(R.id.buttonProceed);

        setSupportActionBar(toolbar);

        toneGeneratorKeypad = new ToneGenerator(AudioManager.STREAM_DTMF,70);




        etVerificationCode.setOnTouchListener(otl);

        buttonProceed.setEnabled(false);

        etVerificationCode.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            @SuppressLint("LongLogTag")
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //                Log.d(TAG, "count(beforeTextChanged)===>"+count);
            }

            @SuppressLint("LongLogTag")
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "count(onTextChanged)===>" + count);
                if (count >= 6) {
                    Log.d(TAG, "count===>" + count);
                    //etVerificationCode.setEnabled(false);
                    buttonProceed.setEnabled(true);
                } else {
                    Log.d(TAG, "else count===>" + count);
                    buttonProceed.setEnabled(false);
                }
            }
        });


        etVerificationCode.setOnEditorActionListener(new EditText.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.d(TAG, "actionId===>" + actionId);
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //                    performClickAction();
                    return true;
                } else if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    return true;
                }
                return false;
            }
        });


        try {

            buttonClear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (userEntered.length() > 0) {
                        userEntered = userEntered.substring(0, userEntered.length() - 1);
                        Log.v("PinView", "User entered=" + userEntered);
                        etVerificationCode.setText(userEntered);
                    }
                }
            });

            buttonProceed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verificationCode = etVerificationCode.getText().toString().trim();

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            View.OnClickListener pinButtonHandler = new View.OnClickListener() {
                public void onClick(View v) {
                    Button pressedButton = (Button) v;
                    if (userEntered.length() < PIN_LENGTH) {
                        userEntered = userEntered + pressedButton.getText();

                        if(pressedButton.getText().toString().equalsIgnoreCase("0")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_0, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("1")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_1, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("2")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_2, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("3")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_3, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("4")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_4, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("5")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_5, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("6")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_6, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("7")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_7, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("8")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_8, 120);
                        } else if(pressedButton.getText().toString().equalsIgnoreCase("9")){
                            toneGeneratorKeypad.stopTone();
                            toneGeneratorKeypad.startTone(ToneGenerator.TONE_DTMF_9, 120);
                        }

                        Log.v("PinView", "User entered=" + userEntered);
                        etVerificationCode.setText(userEntered);
                    }
                }
            };

            // Keypad click listener
            button0.setOnClickListener(pinButtonHandler);
            button1.setOnClickListener(pinButtonHandler);
            button2.setOnClickListener(pinButtonHandler);
            button3.setOnClickListener(pinButtonHandler);
            button4.setOnClickListener(pinButtonHandler);
            button5.setOnClickListener(pinButtonHandler);
            button6.setOnClickListener(pinButtonHandler);
            button7.setOnClickListener(pinButtonHandler);
            button8.setOnClickListener(pinButtonHandler);
            button9.setOnClickListener(pinButtonHandler);




//            buttonClear.setOnClickListener(pinButtonHandler);
//            buttonProceed.setOnClickListener(pinButtonHandler);
//
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
