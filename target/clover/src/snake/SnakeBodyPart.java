/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package snake;

import javafx.geometry.Point2D;
import lombok.Getter;

import java.awt.*;
import java.util.Vector;

/**
 * Class representing one body part (or "tile") of the snake
 */
public class SnakeBodyPart {public static class __CLR4_4_1oioikae7iefk{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589910247292L,8589935092L,900,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    /**
     * Point representing the position of the body part
     */
    @Getter
    private Point pos;

    /**
     * Constructor that takes position as parameter
     *
     * @param p Point(int x, int y)
     */
    public SnakeBodyPart(Point p) {try{__CLR4_4_1oioikae7iefk.R.inc(882);
        __CLR4_4_1oioikae7iefk.R.inc(883);this.pos = p;
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}

    /**
     * Constructor that takes SnakeBodyPart as parameter
     *
     * @param part SnakeBodyPart
     */
    public SnakeBodyPart(SnakeBodyPart part) {try{__CLR4_4_1oioikae7iefk.R.inc(884);
        __CLR4_4_1oioikae7iefk.R.inc(885);set(part);
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}

    /**
     * Set point by Point object
     *
     * @param p Point
     */
    public void set(Point p) {try{__CLR4_4_1oioikae7iefk.R.inc(886);
        __CLR4_4_1oioikae7iefk.R.inc(887);this.pos = p;
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}

    /**
     * Set point by x and y coordinates
     *
     * @param x position
     * @param y position
     */
    public void set(int x, int y) {try{__CLR4_4_1oioikae7iefk.R.inc(888);
        __CLR4_4_1oioikae7iefk.R.inc(889);this.pos = new Point(x,y);
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}

    /**
     * Set part from other SnakeBodyPart object
     *
     * @param part SnakeBodyPart
     */
    public void set(SnakeBodyPart part) {try{__CLR4_4_1oioikae7iefk.R.inc(890);
        __CLR4_4_1oioikae7iefk.R.inc(891);this.pos = part.getPos();
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}

    /**
     * Compares position to other SnakeBodyPart
     *
     * @param other SnakeBodyPart
     * @return {@code true} if other part's X and Y coordinates match with X and Y of this, {@code false} otherwise.
     */
    public Boolean equals(SnakeBodyPart other){try{__CLR4_4_1oioikae7iefk.R.inc(892);
        __CLR4_4_1oioikae7iefk.R.inc(893);if((((other.getPos().getX() == this.getPos().getX() && other.getPos().getY() == this.getPos().getY())&&(__CLR4_4_1oioikae7iefk.R.iget(894)!=0|true))||(__CLR4_4_1oioikae7iefk.R.iget(895)==0&false))) {{
            __CLR4_4_1oioikae7iefk.R.inc(896);return true;
        }
        }__CLR4_4_1oioikae7iefk.R.inc(897);return false;
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}

    /**
     * Compares position to pickup's position
     *
     * @param other Pickup
     * @return {@code true} if pickup's X and Y coordinates match with X and Y of this bodypart, {@code false} otherwise.
     */
    public Boolean equals(Pickup other){try{__CLR4_4_1oioikae7iefk.R.inc(898);
        __CLR4_4_1oioikae7iefk.R.inc(899);return this.getPos().x == other.getPos().x && this.getPos().y == other.getPos().y;
    }finally{__CLR4_4_1oioikae7iefk.R.flushNeeded();}}
}
