package com.demodb.model;

import android.database.sqlite.SQLiteDatabase;

import com.demodb.HockeyPlayerModel;
import com.google.auto.value.AutoValue;
import com.squareup.sqldelight.RowMapper;

/**
 * Created by ANISH on 16-10-2016.
 */
@AutoValue
public abstract class HockeyPlayer implements HockeyPlayerModel
{
    public static final Factory<HockeyPlayer> FACTORY= new Factory<>(AutoValue_HockeyPlayer::new);

    public static RowMapper<HockeyPlayer> MAPPER= FACTORY.select_by_nameMapper();

    public static void insert(SQLiteDatabase db,long _id,long number,String name)
    {
        db.insert(HockeyPlayer.TABLE_NAME,null,HockeyPlayer.FACTORY.marshal()
                ._id(_id)
                .number(number)
                .name(name)
                .asContentValues());
    }
}
