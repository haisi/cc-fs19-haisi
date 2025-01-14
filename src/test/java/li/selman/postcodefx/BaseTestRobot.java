/*
 * Copyright (c) 2019 by Hasan Selman Kara
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package li.selman.postcodefx;

import javafx.scene.control.TextField;
import org.testfx.api.FxRobot;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author Hasan Selman Kara
 */
abstract class BaseTestRobot {

    private final FxRobot fxRobot;

    protected BaseTestRobot(FxRobot fxRobot) {
        this.fxRobot = fxRobot;
    }

    protected void runInJavaFxThread(Runnable runnable) {
        var future = WaitForAsyncUtils.asyncFx(runnable);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    protected <T> T runInJavaFxThread(Callable<T> callable) {
        var future = WaitForAsyncUtils.asyncFx(callable);
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    protected void writeTextfield(final String query, final String text) {
        var textfield = fxRobot.lookup(query).queryAs(TextField.class);
        fxRobot.clickOn(textfield)
               .write(text, 20);
    }

    protected void setTextfield(final String query, final String text) {
        var textfield = fxRobot.lookup(query).queryAs(TextField.class);
        runInJavaFxThread(() -> textfield.setText(text));
    }

}
