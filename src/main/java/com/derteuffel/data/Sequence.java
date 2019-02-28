package com.derteuffel.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by neword on 28/02/2019.
 */
@Entity
public class Sequence implements Serializable {

    @Id
    @GeneratedValue
    Long sequenceId;

    private Long sequenceNumber;
}
