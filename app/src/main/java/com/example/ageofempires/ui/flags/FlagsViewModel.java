package com.example.ageofempires.ui.flags;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FlagsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FlagsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is flags fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}