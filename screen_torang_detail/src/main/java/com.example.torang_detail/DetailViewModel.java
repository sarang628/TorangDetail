package com.example.torang_detail;

import android.app.Activity;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.torang_core.data.model.User;


public class DetailViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> currentRestaurantId = new MutableLiveData<>();
    private MutableLiveData<Integer> userId = new MutableLiveData<>();
    private MutableLiveData<User> profile = new MutableLiveData<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setRestaurantId(int restaurantId) {
        currentRestaurantId.setValue(restaurantId);
    }

    public MutableLiveData<Integer> getCurrentRestaurantId() {
        return currentRestaurantId;
    }

    public void setUserId(Integer userId) {
        this.userId.setValue(userId);
    }

    public MutableLiveData<Integer> getUserId() {
        return userId;
    }

    public void clickProfile(User userBody) {
        profile.setValue(userBody);
    }

    public void observeClickProfile(LifecycleOwner lifecycleOwner, Observer<User> observer) {
        profile.observe(lifecycleOwner, observer);
    }
}
