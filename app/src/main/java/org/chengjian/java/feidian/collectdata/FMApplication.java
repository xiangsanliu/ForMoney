package org.chengjian.java.feidian.collectdata;

import android.app.Application;
import android.content.Context;

/**
 * Created by StormPhoenix on 17-9-30.
 * StormPhoenix is a intelligent Android developer.
 */

public class FMApplication extends Application {

    private static Context instance = null;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private void initImageLoader() {
//        ImagePicker imagePicker = ImagePicker.getInstance();
//        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
//        imagePicker.setShowCamera(true);                      //显示拍照按钮
//        imagePicker.setCrop(false);                           //允许裁剪（单选才有效）
//        imagePicker.setSaveRectangle(true);                   //是否按矩形区域保存
//        imagePicker.setSelectLimit(10);              //选中数量限制
//        imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
//        imagePicker.setFocusWidth(800);                       //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setFocusHeight(800);                      //裁剪框的高度。单位像素（圆形自动取宽高最小值）
//        imagePicker.setOutPutX(1000);                         //保存文件的宽度。单位像素
//        imagePicker.setOutPutY(1000);
//        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
//                .cacheOnDisc(true)
//                .cacheInMemory(true)
//                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .build();
//        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(this)
//                .defaultDisplayImageOptions(displayImageOptions)
//                .memoryCache(new WeakMemoryCache())
//                .build();
//        ImageLoader.getInstance().init(imageLoaderConfiguration);
    }
}
