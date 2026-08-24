/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.mycompany.hospital;

/**
 *
 * @author User
 */
public class BedUnavailableException extends Exception {

    /**
     * Creates a new instance of <code>BedUnavailableException</code> without
     * detail message.
     */
    public BedUnavailableException() {
    }

    /**
     * Constructs an instance of <code>BedUnavailableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BedUnavailableException(String msg) {
        super(msg);
    }
}
