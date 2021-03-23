package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController controller;
    TrainUser user;
    TrainSensor sensor;


    @Before
    public void before() {
        controller = mock(TrainController.class);
        user = mock(TrainUser.class);
        sensor = new TrainSensorImpl(controller,user);
        when(controller.getReferenceSpeed()).thenReturn(100);

    }

    @Test
    public void TooHighSpeedLimitTest() {
        sensor.overrideSpeedLimit(505);
        verify(user).setAlarmState(true);
    }
    @Test
    public void TooLowSpeedLimitTest() {
        sensor.overrideSpeedLimit(-5);
        verify(user).setAlarmState(true);
    }
    @Test
    public void TooLowSpeedLimitTest2() {
        sensor.overrideSpeedLimit(3);
        verify(user).setAlarmState(true);
    }
    @Test
    public void OptimalSpeedLimitTest() {
        sensor.overrideSpeedLimit(80);
        verify(user).setAlarmState(false);
    }
}
