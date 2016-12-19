package com.lichao.testliteorm;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button delete_object, delete_list, delete_table, delete_database;
	private Button add_database, add_moredatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        delete_object = (Button) findViewById(R.id.delete_object);
        delete_list = (Button) findViewById(R.id.delete_list);
        delete_table = (Button) findViewById(R.id.delete_table);
        delete_database = (Button) findViewById(R.id.delete_database);
        add_moredatabase = (Button) findViewById(R.id.add_moredatabase);
        
        add_database = (Button) findViewById(R.id.add_database);
        
        final Account account1=new Account(0, "1078", "1078", "192.168.1.1", "lichao1",1);
        
        Account account2=new Account(1, "1079", "1079", "192.168.1.1", "lichao2",1);
        Account account3=new Account("1079", "1079", "192.168.1.1",0);
        
//        DatabaseManager.INSTANCE.save(account2);
//        DatabaseManager.INSTANCE.save(account3);
        
        //插入多条数据
        Account account4=new Account("1079", "1079", "192.168.1.4",0);
        Account account5=new Account("1079", "1079", "192.168.1.5",0);
        Account account6=new Account("1079", "1079", "192.168.1.6",0);
        final List<Account> list = new ArrayList<Account>();
        list.add(account4);
        list.add(account5);
        list.add(account6);
        
        
        delete_object.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
        
        delete_list.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
        
        delete_table.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatabaseManager.INSTANCE.delete(Account.class);
			}
		});
        
        delete_database.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
        
        add_database.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatabaseManager.INSTANCE.save(account1);
				Log.i("lichao", list.toString());
			}
		});
        
        add_moredatabase.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DatabaseManager.INSTANCE.save(list);
			}
		});
        
    }
}
