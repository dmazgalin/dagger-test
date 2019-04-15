package com.dagger.test.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dagger.test.model.CmsItem;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<CmsItem>> cmsLiveData;
    List<CmsItem> items = new ArrayList<>();

    public MainViewModel() {
        items.add(new CmsItem("www.e1.ru", "E1", ""));
        items.add(new CmsItem("www.lenta.ru", "Lenta", ""));
        items.add(new CmsItem("www.vz.ru", "VZ", ""));
    }

    public void onNativeVideoClick() {
        //TODO: open feature module here
    }

    public LiveData<List<CmsItem>> getCmsLiveData() {
        if (cmsLiveData == null) {
            cmsLiveData = new MutableLiveData<>();
            cmsLiveData.setValue(items);
        }
        return cmsLiveData;
    }
}
