package com.demodb;

import android.app.Application;

import com.demodb.db_helper.BooksOpenHelper;
import com.demodb.db_helper.DatabaseManager;
import com.facebook.stetho.Stetho;

/**
 * Created by anish on 17-10-2016.
 */
public class BookApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.initialize(BooksOpenHelper.getInstance((this)));
        BooksOpenHelper.getInstance((this)).createDataBase(this);


        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
