package com.example.jisuanqi03;

import java.math.BigDecimal;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
	// �����ؼ�
	Button btn_0;
	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	Button btn_9;
	
	Button btn_jia;
	Button btn_jian;
	Button btn_cheng;
	Button btn_chu;
	
	Button btn_dian;
	
	Button btn_c;
	Button btn_d;
	Button btn_dengyu;
	EditText et_input;
	
	int data1, data2, result; // ��������������
	char op; // �����
	boolean flag=true;  //flagΪtrue����ʾ�滻��  false����ʾ����
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ʵ�����ؼ�,��ȡ��ť
		 	btn_0=(Button)findViewById(R.id.btn_0);
	        btn_1=(Button)findViewById(R.id.btn_1);
	        btn_2=(Button)findViewById(R.id.btn_2);
	        btn_3=(Button)findViewById(R.id.btn_3);
	        btn_4=(Button)findViewById(R.id.btn_4);
	        btn_5=(Button)findViewById(R.id.btn_5);
	        btn_6=(Button)findViewById(R.id.btn_6);
	        btn_7=(Button)findViewById(R.id.btn_7);
	        btn_8=(Button)findViewById(R.id.btn_8);
	        btn_9=(Button)findViewById(R.id.btn_9);
	        
	        btn_jia=(Button)findViewById(R.id.btn_jia);
	        btn_jian=(Button)findViewById(R.id.btn_jian);
	        btn_chu=(Button)findViewById(R.id.btn_chu);
	        btn_cheng=(Button)findViewById(R.id.btn_cheng);
	        
	        btn_dian=(Button)findViewById(R.id.btn_dian);
	        
	        btn_c=(Button)findViewById(R.id.btn_c);
	        btn_d=(Button)findViewById(R.id.btn_d);
	        
	        btn_dengyu=(Button)findViewById(R.id.btn_dengyu);
	        et_input=(EditText)findViewById(R.id.et_input);
	        //�����¼�����
	        btn_0.setOnClickListener(new numClickListener());
	        btn_1.setOnClickListener(new numClickListener());
	        btn_2.setOnClickListener(new numClickListener());
	        btn_3.setOnClickListener(new numClickListener());
	        btn_4.setOnClickListener(new numClickListener());
	        btn_5.setOnClickListener(new numClickListener());
	        btn_6.setOnClickListener(new numClickListener());
	        btn_7.setOnClickListener(new numClickListener());
	        btn_8.setOnClickListener(new numClickListener());
	        btn_9.setOnClickListener(new numClickListener());
	        
	        btn_dian.setOnClickListener(new numClickListener());
	        
	        btn_jia.setOnClickListener(new OpListener());
	        btn_jian.setOnClickListener(new OpListener());
	        btn_chu.setOnClickListener(new OpListener());
	        btn_cheng.setOnClickListener(new OpListener());
	
	        btn_c.setOnClickListener(new OpListener());
	        btn_d.setOnClickListener(new OpListener());
	        btn_dengyu.setOnClickListener(new DengYuListener());
	}


	// ���ּ��ļ�����
		class numClickListener implements OnClickListener {
			public void onClick(View v) {	
				String str = ((Button)v).getText().toString();
				if(flag){  
					et_input.setText(str);
				}else{
					et_input.setText(et_input.getText().toString() + str );
				}
				flag = false ; //�޸�Ϊ����״̬
			}

		}
		
		class OpListener implements OnClickListener {
			public void onClick(View v) {
				//���������
				if(v.equals(btn_jia)){
					op = '+';
				}else if(v.equals(btn_jian)){
					op = '-';
				}else if(v.equals(btn_chu)){
					op = '/';
				}else if(v.equals(btn_cheng)){
					op = '*';
				}else if(v.equals(btn_c)){
					et_input.setText("");
					return;
				}else if(v.equals(btn_d)){
					et_input.setText("");
					return;
				}
				data1 = Integer.parseInt(et_input.getText().toString());
				flag = true; //�滻
			}

		}

		
		class DengYuListener implements OnClickListener {
			public void onClick(View v) {
				data2 = Integer.parseInt(et_input.getText().toString());
				//����
				switch(op){
				case '+':
					result = data1+data2;
					break;
				case '-':
					result = data1-data2;
					break;
				case '/':
					result = data1/data2;
					break;
				case '*':
					result = data1*data2;
					break;
				}
				//��ʾ���
				et_input.setText(String.valueOf(result));
				flag = true;//�޸�flag��״̬
			}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
}
