package com.samsung.hyunjaee.kim.boostcamp.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.samsung.hyunjaee.kim.boostcamp.main.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
@SuppressWarnings("unused")
public interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    ViewModel bindMainViewModel(MainViewModel mainViewModel);

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);
}
