package com.nutmeg.wikipedia.injection;

import com.nutmeg.wikipedia.core.CoreComponent;
import com.nutmeg.wikipedia.core.api.WikiClient;
import com.nutmeg.wikipedia.injection.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(dependencies = CoreComponent.class,
           modules = ApplicationModule.class)
public interface ApplicationComponent {

    WikiClient wikiClient();

}
