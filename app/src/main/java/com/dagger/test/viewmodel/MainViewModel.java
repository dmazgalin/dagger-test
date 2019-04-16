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
        items.add(new CmsItem("www.e1.ru", "E1", "https://is1-ssl.mzstatic.com/image/thumb/Purple118/v4/9b/cb/85/9bcb85cb-5245-4940-a345-37b75c391c95/mzl.wskrmrxd.png/246x0w.jpg"));
        items.add(new CmsItem("www.lenta.ru", "Lenta", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTz7YtIyMoYZ2eBJKduQ9wNZvFBz6ODv8UKqN80BFqGI5XI6dOM"));
        items.add(new CmsItem("www.vz.ru", "VZ", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgzQy3OsN1kZ6w193lEkF0Wsv3GRFYyo-KGXTLBc3sYm1nh-7sIw"));
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
