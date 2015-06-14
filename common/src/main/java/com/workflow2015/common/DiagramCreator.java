package com.workflow2015.common;

import com.github.rmannibucau.DiagramGeneratorMojo;
import com.github.rmannibucau.loader.spi.FileType;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DiagramCreator
{
    public void execute() throws MojoFailureException, MojoExecutionException {
        DiagramGeneratorMojo mojo = new DiagramGeneratorMojo();
        mojo.setFileType("java");
        mojo.setType("camel");
        mojo.setFormat("png");
        mojo.setHeight(1200);
        mojo.setWidth(800);
        mojo.setView(false);
        mojo.setAdjust(true);
        mojo.setOutput(new File("/Users/kumar/Desktop/"));
        mojo.setInput("com.workflow2015.service");
        System.setProperty("java.awt.headless", "false");
        mojo.execute();
    }

}