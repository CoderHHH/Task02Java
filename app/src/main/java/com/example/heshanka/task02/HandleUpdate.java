package com.example.heshanka.task02;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.MotionEvent;

import org.osmdroid.ResourceProxy;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.List;

import static com.example.heshanka.task02.MainActivity.overlayItemArray;

/**
 * Created by Heshanka on 17-Aug-17.
 */


public class HandleUpdate extends ItemizedIconOverlay<OverlayItem> {

    Context context;
    public HandleUpdate(List<OverlayItem> pList, org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener<OverlayItem> pOnItemGestureListener,
                        ResourceProxy pResourceProxy)
    {
        super(pList, pOnItemGestureListener, pResourceProxy);
    }

    @Override
    public void draw(Canvas canvas, MapView mapview, boolean arg2)
    {
        super.draw(canvas, mapview, arg2);


        if(!overlayItemArray.isEmpty())
        {
            //overlayItemArray has only ONE element only, so I hard code to get(0)
            GeoPoint in = (GeoPoint) overlayItemArray.get(0).getPoint();

            Point out = new Point();
            mapview.getProjection().toPixels(in, out);

            Bitmap bm = BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher);
            canvas.drawBitmap(bm,out.x - bm.getWidth()/2,out.y - bm.getHeight()/2,null);
        }
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event, MapView mapView)
    {
        //return super.onSingleTapUp(event, mapView);
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event, MapView mapView)
    {
        return true;
    }
}


