package com.ittianyu.relight.widget.stateful.navigator.route;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;
import com.ittianyu.relight.utils.WidgetUtils;
import com.ittianyu.relight.widget.Widget;
import java.util.UUID;

public class WidgetRouter implements Route {
    private Class<? extends Widget> widgetClass;
    private Object[] params;
    private String path;

    public WidgetRouter(Class<? extends Widget> widgetClass, Object... params) {
        this(null, widgetClass, params);
    }

    public WidgetRouter(String path, Class<? extends Widget> widgetClass, Object... params) {
        this.path = path;
        this.widgetClass = widgetClass;
        this.params = params;
    }

    @Override
    public Widget build(Context context, Lifecycle lifecycle) {
        return WidgetUtils.create(context, lifecycle, widgetClass, params);
    }

    @Override
    public String path() {
        if (path == null) {
            path = UUID.randomUUID().toString();
        }
        return path;
    }
}
