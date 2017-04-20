package com.nutmeg.wikipedia.ui;

import com.nutmeg.wikipedia.core.CoreComponent;
import com.nutmeg.wikipedia.injection.ApplicationComponent;
import com.nutmeg.wikipedia.injection.scopes.FragmentScope;

import javax.inject.Singleton;

import dagger.Component;

@FragmentScope// create a new scope
@Component(dependencies = ApplicationComponent.class,
        modules = CategoryModule.class)
public interface CategoryComponent {

    void inject(CategoryFragment fragment);
}
