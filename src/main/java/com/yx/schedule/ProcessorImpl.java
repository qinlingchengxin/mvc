package com.yx.schedule;


import com.yx.service.PersonService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;

import javax.annotation.Resource;
import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * User: LiWenC
 * Date: 16-9-13
 */
public class ProcessorImpl implements Processor {

    private static Log logger = LogFactory.getLog(ProcessorImpl.class);

    // 执行器
    private TaskExecutor taskExecutor;

    // 业务接口
    @Resource
    private PersonService personService;

    public void process() throws InterruptedException {
        // 使用多线程处理
        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    System.out.println("[Thread " + Thread.currentThread().getId() + " start]");
                    // 业务处理
                    System.out.println("[Thread " + Thread.currentThread().getId() + " end]");
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Override
    public Set<String> getSupportedOptions() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void init(ProcessingEnvironment processingEnv) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}