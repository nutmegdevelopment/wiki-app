package com.nutmeg.wikipedia.core;


import com.nutmeg.wikipedia.core.api.ApiModule;
import com.nutmeg.wikipedia.core.api.WikiClient;
import com.nutmeg.wikipedia.injection.scopes.FragmentScope;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = ApiModule.class) //create a new Application class, add to manifest and instantiate component in Application onCreate
@Singleton
public interface CoreComponent {

    WikiClient wikiClient();

}
