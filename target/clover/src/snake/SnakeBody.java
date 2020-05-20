/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package snake;

import javafx.geometry.Point2D;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.Vector;

/**
 * Class representing Snake's body
 */
@Slf4j
public class SnakeBody {public static class __CLR4_4_1mlmlkae7ief6{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589910247292L,8589935092L,882,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    /**
     * Is snake Placed?
     */
    private Boolean snakePlaced = false;

    /**
     * Vector of SnakeBodyParts
     */
    @Getter
    private Vector<SnakeBodyPart> body = new Vector<SnakeBodyPart>();

    public SnakeBody(){try{__CLR4_4_1mlmlkae7ief6.R.inc(813);

    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Adds a body part to the same position as the snake body's tail, only if snake is placed.
     */
    public void extend(){try{__CLR4_4_1mlmlkae7ief6.R.inc(814);
        __CLR4_4_1mlmlkae7ief6.R.inc(815);if((((!snakePlaced)&&(__CLR4_4_1mlmlkae7ief6.R.iget(816)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(817)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(818);log.error("Snake is not placed yet, can't extend!");
            __CLR4_4_1mlmlkae7ief6.R.inc(819);return;
        }
        }__CLR4_4_1mlmlkae7ief6.R.inc(820);if((((getBody().size() == 0)&&(__CLR4_4_1mlmlkae7ief6.R.iget(821)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(822)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(823);return;
        }
        }__CLR4_4_1mlmlkae7ief6.R.inc(824);SnakeBodyPart tail = new SnakeBodyPart(getBody().lastElement());
        __CLR4_4_1mlmlkae7ief6.R.inc(825);body.add(tail);
        __CLR4_4_1mlmlkae7ief6.R.inc(826);log.info("Snake extended, new size is {}", body.size());
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * If Snake's length is more than 1, Snake's last body part is removed (only if snake is placed)
     */
    public void shrink(){try{__CLR4_4_1mlmlkae7ief6.R.inc(827);
        __CLR4_4_1mlmlkae7ief6.R.inc(828);if((((!snakePlaced)&&(__CLR4_4_1mlmlkae7ief6.R.iget(829)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(830)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(831);log.error("Snake is not placed yet, can't extend!");
            __CLR4_4_1mlmlkae7ief6.R.inc(832);return;
        }
        }__CLR4_4_1mlmlkae7ief6.R.inc(833);if((((body.size() <= 1)&&(__CLR4_4_1mlmlkae7ief6.R.iget(834)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(835)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(836);return;
        }
        }__CLR4_4_1mlmlkae7ief6.R.inc(837);body.remove(body.lastElement());
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Places Snake body at X and Y position of map, with 1 bodypart
     *
     * @param x position
     * @param y position
     */
    public void place(int x, int y){try{__CLR4_4_1mlmlkae7ief6.R.inc(838);
        __CLR4_4_1mlmlkae7ief6.R.inc(839);if((((snakePlaced)&&(__CLR4_4_1mlmlkae7ief6.R.iget(840)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(841)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(842);log.error("Snake is already placed!");
            __CLR4_4_1mlmlkae7ief6.R.inc(843);return;
        }
        }__CLR4_4_1mlmlkae7ief6.R.inc(844);SnakeBodyPart newTail = new SnakeBodyPart(new Point(x,y));
        __CLR4_4_1mlmlkae7ief6.R.inc(845);body.add(newTail);
        __CLR4_4_1mlmlkae7ief6.R.inc(846);snakePlaced = true;
        __CLR4_4_1mlmlkae7ief6.R.inc(847);log.info("Snake placed to ({},{})", x, y);
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Returns element of index i from Vector of body parts
     *
     * @param i index of body part
     * @return element of body
     */
    public SnakeBodyPart get(int i){try{__CLR4_4_1mlmlkae7ief6.R.inc(848);
        __CLR4_4_1mlmlkae7ief6.R.inc(849);return body.get(i);
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Returns last element of snake body
     *
     * @return SnakeBodyPart, last element of body
     */
    public SnakeBodyPart getLast(){try{__CLR4_4_1mlmlkae7ief6.R.inc(850);
        __CLR4_4_1mlmlkae7ief6.R.inc(851);return body.lastElement();
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Returns if head's position is the same as any other body part
     *
     * @return {@code true} if position of first body part is the same as any other body part, {@code false} otherwise
     */
    public Boolean isHeadCollidingWithBody(){try{__CLR4_4_1mlmlkae7ief6.R.inc(852);
        __CLR4_4_1mlmlkae7ief6.R.inc(853);Boolean collides = false;

        __CLR4_4_1mlmlkae7ief6.R.inc(854);for (int i = 1; (((i < size())&&(__CLR4_4_1mlmlkae7ief6.R.iget(855)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(856)==0&false)); i++) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(857);if((((this.get(i).equals(this.get(0)))&&(__CLR4_4_1mlmlkae7ief6.R.iget(858)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(859)==0&false))) {{
                __CLR4_4_1mlmlkae7ief6.R.inc(860);collides = true;
                __CLR4_4_1mlmlkae7ief6.R.inc(861);break;
            }
        }}

        }__CLR4_4_1mlmlkae7ief6.R.inc(862);return collides;
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Sets snake length
     *
     * If Snake's length is lower than given parameter, Snake is extended until its length matches parameter.
     *
     * If Snake's length is higher than given parameter, Snake is shrunk until its length matches parameter.
     *
     * @param length desired length
     */
    public void setSnakeLength(int length){try{__CLR4_4_1mlmlkae7ief6.R.inc(863);
        __CLR4_4_1mlmlkae7ief6.R.inc(864);if((((length < 1)&&(__CLR4_4_1mlmlkae7ief6.R.iget(865)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(866)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(867);log.error("Can't set Snake's length to 0 or lower!");
            __CLR4_4_1mlmlkae7ief6.R.inc(868);return;
        }
        }__CLR4_4_1mlmlkae7ief6.R.inc(869);while((((body.size() != length)&&(__CLR4_4_1mlmlkae7ief6.R.iget(870)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(871)==0&false))) {{
            __CLR4_4_1mlmlkae7ief6.R.inc(872);if((((body.size() < length)&&(__CLR4_4_1mlmlkae7ief6.R.iget(873)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(874)==0&false))) {{
                __CLR4_4_1mlmlkae7ief6.R.inc(875);extend();
            } }else {__CLR4_4_1mlmlkae7ief6.R.inc(876);if((((body.size() > length)&&(__CLR4_4_1mlmlkae7ief6.R.iget(877)!=0|true))||(__CLR4_4_1mlmlkae7ief6.R.iget(878)==0&false))) {{
                __CLR4_4_1mlmlkae7ief6.R.inc(879);shrink();
            }
        }}}
    }}finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}

    /**
     * Returns length of body
     *
     * @return length of body
     */
    public int size(){try{__CLR4_4_1mlmlkae7ief6.R.inc(880);
        __CLR4_4_1mlmlkae7ief6.R.inc(881);return body.size();
    }finally{__CLR4_4_1mlmlkae7ief6.R.flushNeeded();}}
}
