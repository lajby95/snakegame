/* $$ This file has been instrumented by Clover 4.4.1#2019101123313948 $$ */package snake;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnakeTest {static class __CLR4_4_1hjhjkadzrygv{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_4_1();if(2019101123313948L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.4.1#2019101123313948,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u006c\u0061\u006a\u0062\u0079\u002f\u0044\u0045\u002d\u0049\u004b\u0020\u0032\u0030\u0031\u0039\u002d\u0032\u0030\u002d\u0032\u002f\u0050\u0072\u006f\u0067\u0074\u0065\u0063\u0068\u002f\u0048\u0061\u007a\u0069\u005f\u0070\u0072\u006f\u006a\u0065\u006b\u0074\u002f\u0073\u006e\u0061\u006b\u0065\u0067\u0061\u006d\u0065\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1589897256452L,8589935092L,726,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_4_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    Snake snake;

    @BeforeEach
    void initialize(){try{__CLR4_4_1hjhjkadzrygv.R.inc(631);
        __CLR4_4_1hjhjkadzrygv.R.inc(632);snake = new Snake();
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @AfterEach
    void destroy(){try{__CLR4_4_1hjhjkadzrygv.R.inc(633);
        __CLR4_4_1hjhjkadzrygv.R.inc(634);snake = null;
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testPlace(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),635);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1bytvekhn();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testPlace",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),635,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1bytvekhn(){try{__CLR4_4_1hjhjkadzrygv.R.inc(635);
        __CLR4_4_1hjhjkadzrygv.R.inc(636);snake.body.place(17,18);
        __CLR4_4_1hjhjkadzrygv.R.inc(637);assertEquals(17, snake.body.get(0).getPos().x);
        __CLR4_4_1hjhjkadzrygv.R.inc(638);assertEquals(18, snake.body.get(0).getPos().y);
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testPlaceAgain(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),639);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1c1kpf6hr();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testPlaceAgain",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),639,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1c1kpf6hr(){try{__CLR4_4_1hjhjkadzrygv.R.inc(639);
        __CLR4_4_1hjhjkadzrygv.R.inc(640);snake.body.place(17,18);
        __CLR4_4_1hjhjkadzrygv.R.inc(641);snake.body.place(18,19);
        __CLR4_4_1hjhjkadzrygv.R.inc(642);assertEquals(17, snake.body.get(0).getPos().x);
        __CLR4_4_1hjhjkadzrygv.R.inc(643);assertEquals(18, snake.body.get(0).getPos().y);
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testInvalidPlace(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),644);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1w393wphw();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testInvalidPlace",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),644,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1w393wphw(){try{__CLR4_4_1hjhjkadzrygv.R.inc(644);
        __CLR4_4_1hjhjkadzrygv.R.inc(645);assertThrows(IllegalArgumentException.class, () -> snake.place(-1,-1));
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testMove(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),646);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1asihlihy();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testMove",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),646,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1asihlihy(){try{__CLR4_4_1hjhjkadzrygv.R.inc(646);
        __CLR4_4_1hjhjkadzrygv.R.inc(647);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(648);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(649);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(650);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(651);assertEquals(17, snake.body.get(0).getPos().x);
        __CLR4_4_1hjhjkadzrygv.R.inc(652);assertEquals(14, snake.body.get(0).getPos().y);

        __CLR4_4_1hjhjkadzrygv.R.inc(653);snake.setDirection('r');
        __CLR4_4_1hjhjkadzrygv.R.inc(654);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(655);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(656);snake.setDirection('d');
        __CLR4_4_1hjhjkadzrygv.R.inc(657);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(658);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(659);assertEquals(19, snake.body.get(0).getPos().x);
        __CLR4_4_1hjhjkadzrygv.R.inc(660);assertEquals(16, snake.body.get(0).getPos().y);
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testDirectionUpDown(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),661);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1njxacvid();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testDirectionUpDown",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),661,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1njxacvid(){try{__CLR4_4_1hjhjkadzrygv.R.inc(661);
        __CLR4_4_1hjhjkadzrygv.R.inc(662);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(663);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(664);snake.setDirection('d');
        __CLR4_4_1hjhjkadzrygv.R.inc(665);assertEquals('u', snake.getDirection());
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testDirectionDownUp(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),666);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_178az73ii();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testDirectionDownUp",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),666,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_178az73ii(){try{__CLR4_4_1hjhjkadzrygv.R.inc(666);
        __CLR4_4_1hjhjkadzrygv.R.inc(667);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(668);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(669);snake.setDirection('r');
        __CLR4_4_1hjhjkadzrygv.R.inc(670);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(671);snake.setDirection('d');
        __CLR4_4_1hjhjkadzrygv.R.inc(672);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(673);snake.setDirection('u');
        __CLR4_4_1hjhjkadzrygv.R.inc(674);assertEquals('d', snake.getDirection());
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testDirectionLeftRight(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),675);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1olyqr5ir();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testDirectionLeftRight",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),675,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1olyqr5ir(){try{__CLR4_4_1hjhjkadzrygv.R.inc(675);
        __CLR4_4_1hjhjkadzrygv.R.inc(676);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(677);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(678);snake.setDirection('l');
        __CLR4_4_1hjhjkadzrygv.R.inc(679);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(680);snake.setDirection('r');
        __CLR4_4_1hjhjkadzrygv.R.inc(681);assertEquals('l', snake.getDirection());
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testDirectionRightLeft(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),682);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1po0sotiy();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testDirectionRightLeft",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),682,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1po0sotiy(){try{__CLR4_4_1hjhjkadzrygv.R.inc(682);
        __CLR4_4_1hjhjkadzrygv.R.inc(683);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(684);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(685);snake.setDirection('r');
        __CLR4_4_1hjhjkadzrygv.R.inc(686);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(687);snake.setDirection('l');
        __CLR4_4_1hjhjkadzrygv.R.inc(688);assertEquals('r', snake.getDirection());
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testSnakeLength(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),689);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1aoutb9j5();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testSnakeLength",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),689,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1aoutb9j5(){try{__CLR4_4_1hjhjkadzrygv.R.inc(689);
        __CLR4_4_1hjhjkadzrygv.R.inc(690);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(691);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(692);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(693);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(694);assertEquals(4, snake.body.size());
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testGoToOtherSide(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),695);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1ycqwivjb();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testGoToOtherSide",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),695,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1ycqwivjb(){try{__CLR4_4_1hjhjkadzrygv.R.inc(695);
        __CLR4_4_1hjhjkadzrygv.R.inc(696);snake.place(0,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(697);snake.setDirection('l');
        __CLR4_4_1hjhjkadzrygv.R.inc(698);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(699);assertEquals(snake.getSizeX()-1, snake.body.get(0).getPos().x);
        __CLR4_4_1hjhjkadzrygv.R.inc(700);assertEquals(17, snake.body.get(0).getPos().y);
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}

    @Test
    void testSnakeDie(){__CLR4_4_1hjhjkadzrygv.R.globalSliceStart(getClass().getName(),701);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_4_1yjxqnbjh();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_4_1hjhjkadzrygv.R.rethrow($CLV_t2$);}finally{__CLR4_4_1hjhjkadzrygv.R.globalSliceEnd(getClass().getName(),"snake.SnakeTest.testSnakeDie",__CLR4_4_1_TEST_NAME_SNIFFER.getTestName(),701,$CLV_p$,$CLV_t$);}}private void  __CLR4_4_1yjxqnbjh(){try{__CLR4_4_1hjhjkadzrygv.R.inc(701);
        __CLR4_4_1hjhjkadzrygv.R.inc(702);snake.place(17,17);
        __CLR4_4_1hjhjkadzrygv.R.inc(703);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(704);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(705);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(706);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(707);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(708);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(709);snake.body.extend();
        __CLR4_4_1hjhjkadzrygv.R.inc(710);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(711);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(712);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(713);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(714);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(715);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(716);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(717);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(718);snake.setDirection('l');
        __CLR4_4_1hjhjkadzrygv.R.inc(719);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(720);snake.setDirection('d');
        __CLR4_4_1hjhjkadzrygv.R.inc(721);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(722);snake.setDirection('r');

        __CLR4_4_1hjhjkadzrygv.R.inc(723);assertEquals(false, snake.getDied());
        __CLR4_4_1hjhjkadzrygv.R.inc(724);snake.move();
        __CLR4_4_1hjhjkadzrygv.R.inc(725);assertEquals(true, snake.getDied());
    }finally{__CLR4_4_1hjhjkadzrygv.R.flushNeeded();}}
}
