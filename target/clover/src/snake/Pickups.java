/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package snake;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class representing pickups on the map
 */
public class Pickups {public static class __CLR4_4_1klklkae7iee2{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589910247292L,8589935092L,813,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    /**
     * Vector storing all pickups currently on map
     */
    private Vector<Pickup> pickups = new Vector<Pickup>();

    /**
     * When was the last pickup placed
     */
    @Getter
    long lastPlacementTime;

    /**
     * When was the last pickup eaten
     */
    @Getter
    long lastEatenTime;

    /**
     * How many pickups were eaten
     */
    @Getter
    private int pickupsEaten = 0;

    /**
     * Stores upper limits that can be placed of all types of pickups
     */
    HashMap<String, Integer> maxPickupCounts = new HashMap<String, Integer>();

    /**
     * Stores how many pickups of all types are currently on the map
     */
    HashMap<String, Integer> countOfPickups = new HashMap<String, Integer>();

    /**
     * Stores if effectTimers are enabled for given type of pickups
     */
    @Getter
    HashMap<String, Boolean> effectTimers = new HashMap<String, Boolean>();

    /**
     * Stores effectDurations for given type of pickups
     */
    @Getter
    HashMap<String, Integer> effectDurations = new HashMap<String, Integer>();

    /**
     * Stores Points for given type of pickups
     */
    @Getter
    HashMap<String, Integer> Points = new HashMap<String, Integer>();

    /**
     * Initialize properties of all types of pickups
     */
    public Pickups(){try{__CLR4_4_1klklkae7iee2.R.inc(741);
        __CLR4_4_1klklkae7iee2.R.inc(742);maxPickupCounts.put("apple", 3);
        __CLR4_4_1klklkae7iee2.R.inc(743);maxPickupCounts.put("speedup", 5);
        __CLR4_4_1klklkae7iee2.R.inc(744);maxPickupCounts.put("slowdown", 3);
        __CLR4_4_1klklkae7iee2.R.inc(745);maxPickupCounts.put("size1", 2);

        __CLR4_4_1klklkae7iee2.R.inc(746);countOfPickups.put("apple", 0);
        __CLR4_4_1klklkae7iee2.R.inc(747);countOfPickups.put("speedup", 0);
        __CLR4_4_1klklkae7iee2.R.inc(748);countOfPickups.put("slowdown", 0);
        __CLR4_4_1klklkae7iee2.R.inc(749);countOfPickups.put("size1", 0);



        __CLR4_4_1klklkae7iee2.R.inc(750);effectTimers.put("apple", false);
        __CLR4_4_1klklkae7iee2.R.inc(751);effectTimers.put("speedup", true);
        __CLR4_4_1klklkae7iee2.R.inc(752);effectTimers.put("slowdown", true);
        __CLR4_4_1klklkae7iee2.R.inc(753);effectTimers.put("size1", true);

        __CLR4_4_1klklkae7iee2.R.inc(754);effectDurations.put("apple", 0);
        __CLR4_4_1klklkae7iee2.R.inc(755);effectDurations.put("speedup", 10);
        __CLR4_4_1klklkae7iee2.R.inc(756);effectDurations.put("slowdown", 10);
        __CLR4_4_1klklkae7iee2.R.inc(757);effectDurations.put("size1", 15);

        __CLR4_4_1klklkae7iee2.R.inc(758);Points.put("apple", 100);
        __CLR4_4_1klklkae7iee2.R.inc(759);Points.put("speedup", 500);
        __CLR4_4_1klklkae7iee2.R.inc(760);Points.put("slowdown", 50);
        __CLR4_4_1klklkae7iee2.R.inc(761);Points.put("size1", 50);
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public void place(Pickup p){try{__CLR4_4_1klklkae7iee2.R.inc(762);
        __CLR4_4_1klklkae7iee2.R.inc(763);pickups.add(p);
        __CLR4_4_1klklkae7iee2.R.inc(764);lastPlacementTime = System.currentTimeMillis();
        __CLR4_4_1klklkae7iee2.R.inc(765);countOfPickups.put(p.getType(), countOfPickups.get(p.getType())+1);
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public Pickup get(int i){try{__CLR4_4_1klklkae7iee2.R.inc(766);
        __CLR4_4_1klklkae7iee2.R.inc(767);return pickups.get(i);
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public Vector<Pickup> getAll(){try{__CLR4_4_1klklkae7iee2.R.inc(768);
        __CLR4_4_1klklkae7iee2.R.inc(769);return pickups;
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public Vector<Pickup> getAll(String type){try{__CLR4_4_1klklkae7iee2.R.inc(770);
        __CLR4_4_1klklkae7iee2.R.inc(771);Vector<Pickup> ps = new Vector<Pickup>();

        __CLR4_4_1klklkae7iee2.R.inc(772);for(Pickup p : pickups){{
            __CLR4_4_1klklkae7iee2.R.inc(773);if((((p.getType().equals(type))&&(__CLR4_4_1klklkae7iee2.R.iget(774)!=0|true))||(__CLR4_4_1klklkae7iee2.R.iget(775)==0&false))) {{
                __CLR4_4_1klklkae7iee2.R.inc(776);ps.add(p);
            }
        }}

        }__CLR4_4_1klklkae7iee2.R.inc(777);return ps;
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public int getCountOfType(String type){try{__CLR4_4_1klklkae7iee2.R.inc(778);
        __CLR4_4_1klklkae7iee2.R.inc(779);int count = 0;
        __CLR4_4_1klklkae7iee2.R.inc(780);for(Pickup p : pickups){{
            __CLR4_4_1klklkae7iee2.R.inc(781);if((((p.getType().equals(type))&&(__CLR4_4_1klklkae7iee2.R.iget(782)!=0|true))||(__CLR4_4_1klklkae7iee2.R.iget(783)==0&false))) {{
                __CLR4_4_1klklkae7iee2.R.inc(784);count++;
            }
        }}

        }__CLR4_4_1klklkae7iee2.R.inc(785);return count;
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public Pickup eat(int i){try{__CLR4_4_1klklkae7iee2.R.inc(786);
        __CLR4_4_1klklkae7iee2.R.inc(787);lastEatenTime = System.currentTimeMillis();
        __CLR4_4_1klklkae7iee2.R.inc(788);pickupsEaten++;
        __CLR4_4_1klklkae7iee2.R.inc(789);Pickup p = this.get(i);
        __CLR4_4_1klklkae7iee2.R.inc(790);countOfPickups.put(p.getType(), countOfPickups.get(p.getType())-1);
        __CLR4_4_1klklkae7iee2.R.inc(791);return pickups.remove(i);
    }finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public Boolean canPlacePickup(){try{__CLR4_4_1klklkae7iee2.R.inc(792);
        __CLR4_4_1klklkae7iee2.R.inc(793);double interval = 3;            // seconds

        __CLR4_4_1klklkae7iee2.R.inc(794);long currentTimestamp = System.currentTimeMillis();
        __CLR4_4_1klklkae7iee2.R.inc(795);if(
                (((currentTimestamp >= (this.getLastPlacementTime()+interval*1000)
                && currentTimestamp >= (this.getLastEatenTime()+interval*1000)
        )&&(__CLR4_4_1klklkae7iee2.R.iget(796)!=0|true))||(__CLR4_4_1klklkae7iee2.R.iget(797)==0&false))) {{
            __CLR4_4_1klklkae7iee2.R.inc(798);return true;
        } }else {{
            __CLR4_4_1klklkae7iee2.R.inc(799);return false;
        }
    }}finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}

    public String getNextRandomPlaceablePickup(){try{__CLR4_4_1klklkae7iee2.R.inc(800);
        __CLR4_4_1klklkae7iee2.R.inc(801);ArrayList<String> pickups = new ArrayList<String>();
        __CLR4_4_1klklkae7iee2.R.inc(802);for(String s : maxPickupCounts.keySet()) {{
            __CLR4_4_1klklkae7iee2.R.inc(803);if((((countOfPickups.get(s) < maxPickupCounts.get(s) )&&(__CLR4_4_1klklkae7iee2.R.iget(804)!=0|true))||(__CLR4_4_1klklkae7iee2.R.iget(805)==0&false))) {{
                __CLR4_4_1klklkae7iee2.R.inc(806);pickups.add(s);
            }
        }}

        }__CLR4_4_1klklkae7iee2.R.inc(807);if((((pickups.size() == 0)&&(__CLR4_4_1klklkae7iee2.R.iget(808)!=0|true))||(__CLR4_4_1klklkae7iee2.R.iget(809)==0&false))) {{
            __CLR4_4_1klklkae7iee2.R.inc(810);return "";
        } }else {{
            __CLR4_4_1klklkae7iee2.R.inc(811);int randomIndex = ThreadLocalRandom.current().nextInt(0, pickups.size());
            __CLR4_4_1klklkae7iee2.R.inc(812);return pickups.get(randomIndex);
        }
    }}finally{__CLR4_4_1klklkae7iee2.R.flushNeeded();}}
}
