package com.example.googlecalendar;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.util.Log;

import static android.content.ContentValues.TAG;

    public class MainActivity<hasNext> {
        // 1
        ContentResolver cr = getContentResolver();

        private ContentResolver getContentResolver() {

            // 2
            String[] projection = {
                    CalendarContract.Calendars._ID,
                    CalendarContract.Calendars.NAME,
                    CalendarContract.Calendars.ACCOUNT_NAME,
                    CalendarContract.Calendars.ACCOUNT_TYPE,
            };
            // 3
            Cursor cursor = cr.query(CalendarContract.Calendars.CONTENT_URI, projection, null, null, null);

            for (boolean hasNext = cursor.moveToFirst(); hasNext; hasNext = cursor.moveToNext()) {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String accountName = cursor.getString(2);
                String accountType = cursor.getString(3);

                Log.i(TAG, id + ":" + name);
                Log.i(TAG, accountName);
                Log.i(TAG, accountType);
                Log.i(TAG, "-----------------------------------");
            }
            cursor.close();
            return null;
        }
    }