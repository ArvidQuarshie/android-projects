package bhouse.travellist_starterproject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends Activity implements View.OnClickListener {

  public static final String EXTRA_PARAM_ID = "place_id";
  private ListView mList;
  private ImageView mImageView;
  private TextView mTitle;
  private LinearLayout mTitleHolder;
  private ImageButton mAddButton;
  private RelativeLayout mRevealView;
  private EditText mEditTextTodo;
  private boolean isEditTextVisible;
  private InputMethodManager mInputManager;
  private Place mPlace;
  private ArrayList<String> mTodoList;
  private ArrayAdapter mToDoAdapter;
  int defaultColor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    mPlace = PlaceData.placeList().get(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

    mList = (ListView) findViewById(R.id.list);
    mImageView = (ImageView) findViewById(R.id.placeImage);
    mTitle = (TextView) findViewById(R.id.textView);
    mTitleHolder = (LinearLayout) findViewById(R.id.placeNameHolder);
    //mAddButton = (ImageButton) findViewById(R.id.btn_add);
    mRevealView = (RelativeLayout) findViewById(R.id.TextHolder);
    //mEditTextTodo = (EditText) findViewById(R.id.etTodo);

//    mAddButton.setOnClickListener(this);
    defaultColor = getResources().getColor(R.color.primary_dark);

    //mInputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    mRevealView.setVisibility(View.VISIBLE);
    //isEditTextVisible = false;

    //setUpAdapter();
    loadPlace();
    windowTransition();
    getPhoto();

  }

  private void setUpAdapter() {
    mTodoList = new ArrayList<>();
    mToDoAdapter = new ArrayAdapter(this, R.layout.row_todo, mTodoList);
    mList.setAdapter(mToDoAdapter);
  }

  private void loadPlace() {
    mTitle.setText(mPlace.name);
    mImageView.setImageResource(mPlace.getImageResourceId(this));
  }

  private void windowTransition() {

  }

  private void addToDo(String todo) {
    mTodoList.add(todo);
  }

  private void getPhoto() {
    Bitmap photo = BitmapFactory.decodeResource(getResources(), mPlace.getImageResourceId(this));
      colorize(photo);
  }

  private void colorize(Bitmap photo) {
    Palette mPalette = Palette.generate(photo);
    applyPalette(mPalette);
  }

  private void applyPalette(Palette mPalette) {
    getWindow().setBackgroundDrawable(new ColorDrawable(mPalette.getDarkMutedColor(defaultColor)));
    mTitleHolder.setBackgroundColor(mPalette.getMutedColor(defaultColor));
//    mRevealView.setBackgroundColor(mPalette.getLightVibrantColor(defaultColor));
    //mRevealView.setBackgroundColor(Color.WHITE);

  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
//      case R.id.btn_add:
//        if (!isEditTextVisible) {
//          revealEditText(mRevealView);
//          mEditTextTodo.requestFocus();
//          mInputManager.showSoftInput(mEditTextTodo, InputMethodManager.SHOW_IMPLICIT);
//
//        } else {
//          addToDo(mEditTextTodo.getText().toString());
//          mToDoAdapter.notifyDataSetChanged();
//          mInputManager.hideSoftInputFromWindow(mEditTextTodo.getWindowToken(), 0);
//          hideEditText(mRevealView);
//
//        }
    }
  }

  private void revealEditText(LinearLayout view) {

  }

  private void hideEditText(final LinearLayout view) {

  }

  @Override
  public void onBackPressed() {
    finish();
  }
}
