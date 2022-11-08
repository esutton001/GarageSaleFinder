package com.example.garagesalefinder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.garagesalefinder.PostStuff.Items;
import com.example.garagesalefinder.controllers.DataBaseHelperClass;

public class AddItems extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    EditText postName;
    EditText itemTitle;
    //EditText category;
    String category;
    EditText image;
    EditText description;
    EditText price;
    EditText quantity;
    Button createButton;
    Button returnBtn;

    DataBaseHelperClass dbhc = new DataBaseHelperClass(AddItems.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additems);
        itemTitle = findViewById(R.id.inputItemName);
        postName = findViewById(R.id.inputPostName);
        description = findViewById(R.id.inputDescription);
        //category = findViewById(R.id.inputCategory);
        price = findViewById(R.id.inputPrice);
        image = findViewById(R.id.inputImage);
        quantity = findViewById(R.id.inputQuantity);
        createButton = findViewById(R.id.btnCreate);
        String username = getIntent().getStringExtra("username");
        returnBtn = findViewById(R.id.btnReturn);



        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItems.this, "Item was added", Toast.LENGTH_SHORT).show();
                String pItemTitle = itemTitle.getText().toString().trim();
                String pPostName = postName.getText().toString().trim();
                String pDescription = description.getText().toString().trim();
                //String pCategory = category.getText().toString().trim();
                String pCategory = category;
                String pImage = image.getText().toString().trim();
                String pPrice = price.getText().toString().trim();
                String pQuantity = quantity.getText().toString().trim();

                if(TextUtils.isEmpty(pItemTitle)){//verifies a location was entered
                    itemTitle.setError("Item Title is required.");
                    return;
                }

                if(TextUtils.isEmpty(pPostName)) {
                    postName.setError("Post Name is required.");
                    return;
                }
                Items i = new Items(pPostName, pItemTitle, username, pCategory, pImage,
                        pDescription, pPrice, pQuantity);
                dbhc.addItem(i);
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), AddDates.class));
                finish();
            }
        });

    }
    public void showCategoryChoices(View v){
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_category);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.category1:
                Toast.makeText(this, "Toys was selected", Toast.LENGTH_SHORT).show();
                category = "Toys";
                return true;
            case R.id.category2:
                Toast.makeText(this, "Clothing was selected", Toast.LENGTH_SHORT).show();
                category = "Clothing";
                return true;
            case R.id.category3:
                Toast.makeText(this, "Furniture was selected", Toast.LENGTH_SHORT).show();
                category = "Furniture";
                return true;
            case R.id.category4:
                Toast.makeText(this, "Jewelry was selected", Toast.LENGTH_SHORT).show();
                category = "Jewelry";
                return true;
            case R.id.category5:
                Toast.makeText(this, "Antique was selected", Toast.LENGTH_SHORT).show();
                category = "Antique";
                return true;
            case R.id.category6:
                Toast.makeText(this, "Arts and Crafts was selected", Toast.LENGTH_SHORT).show();
                category = "Arts and Crafts";
                return true;
            case R.id.category7:
                Toast.makeText(this, "Sport was selected", Toast.LENGTH_SHORT).show();
                category = "Sport";
                return true;
            case R.id.category8:
                Toast.makeText(this, "Books was selected", Toast.LENGTH_SHORT).show();
                category = "Books";
                return true;
            case R.id.category9:
                Toast.makeText(this, "Electronics was selected", Toast.LENGTH_SHORT).show();
                category = "Electronics";
                return true;
            case R.id.category10:
                Toast.makeText(this, "Miscellaneous was selected", Toast.LENGTH_SHORT).show();
                category = "Miscellaneous";
                return true;
            default:
                return false;
        }

    }

}

