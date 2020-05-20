/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package snake;

import lombok.Getter;

import java.awt.*;

/**
 * Class representing a pickup for Snake
 */
public class Pickup {public static class __CLR4_4_1k6k6kae7iear{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589910247292L,8589935092L,741,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    /**
     * Position of pickup
     */
    @Getter
    private Point pos;

    /**
     * Type of pickup
     *
     * e.g.: apple, slowdown, speedup, etc.
     */
    @Getter
    private String type;

    /**
     * Stores if pickup has effect that lasts X seconds
     */
    @Getter
    private Boolean effectTimer = false;

    /**
     * If {@code effectTimer} is true, duration stores how many seconds the effect lasts
     */
    @Getter
    private int effectDuration = 10;

    /**
     * Stores the amount of points the player gets upon eating this pickup
     */
    @Getter
    private int points;

    /**
     * Constructor that takes position and type as parameters
     *
     * @param p position
     * @param type of pickup
     */
    public Pickup(Point p, String type){try{__CLR4_4_1k6k6kae7iear.R.inc(726);
        __CLR4_4_1k6k6kae7iear.R.inc(727);this.pos = p;
        __CLR4_4_1k6k6kae7iear.R.inc(728);this.type = type;
    }finally{__CLR4_4_1k6k6kae7iear.R.flushNeeded();}}

    /**
     * Constructor that takes following as parameters:
     *
     * @param p position
     * @param type of pickup
     * @param effectTimer Boolean
     * @param effectDuration duration of pickup's effect
     * @param points points for pickup
     */
    public Pickup(Point p, String type, Boolean effectTimer, int effectDuration, int points){try{__CLR4_4_1k6k6kae7iear.R.inc(729);
        __CLR4_4_1k6k6kae7iear.R.inc(730);this.pos = p;
        __CLR4_4_1k6k6kae7iear.R.inc(731);this.type = type;
        __CLR4_4_1k6k6kae7iear.R.inc(732);this.effectTimer = effectTimer;
        __CLR4_4_1k6k6kae7iear.R.inc(733);this.effectDuration = effectDuration;
        __CLR4_4_1k6k6kae7iear.R.inc(734);this.points = points;
    }finally{__CLR4_4_1k6k6kae7iear.R.flushNeeded();}}

    /**
     * Constructor that takes other {@code Pickup} as parameter
     *
     * @param other Pickup
     */
    public Pickup(Pickup other){try{__CLR4_4_1k6k6kae7iear.R.inc(735);
        __CLR4_4_1k6k6kae7iear.R.inc(736);this.pos = other.getPos();
        __CLR4_4_1k6k6kae7iear.R.inc(737);this.type = other.getType();

        __CLR4_4_1k6k6kae7iear.R.inc(738);this.effectTimer = other.getEffectTimer();
        __CLR4_4_1k6k6kae7iear.R.inc(739);this.effectDuration = other.getEffectDuration();
        __CLR4_4_1k6k6kae7iear.R.inc(740);this.points = other.getPoints();
    }finally{__CLR4_4_1k6k6kae7iear.R.flushNeeded();}}

}
