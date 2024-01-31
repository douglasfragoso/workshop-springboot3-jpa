package com.java.spring.course.model;

import java.io.Serializable;
import java.time.Instant;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.spring.course.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // This annotation is used to format the date
    private Instant moment;

    // @JsonIgnore - se colocar o jsonignore aqui, o json não vai mostrar o cliente e o cliente vai mostrar os pedidos
    @ManyToOne// This annotation is used to create a many-to-one relationship between two entities
    @JoinColumn(name = "client_id") // This annotation is used to specify the foreign key column
    private User client;

    private Integer status;

    @OneToMany(mappedBy = "id.order", fetch = FetchType.EAGER)
	private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // This annotation is used to specify that the order entity is the owner of the relationship
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        setStatus(status);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);// This method is used to convert an integer to an OrderStatus
    }

    public void setStatus(OrderStatus status) {
        if(status != null){
            this.status = status.getCode();// This attribute is used to store the code of the order status
        }
    }

    public Set<OrderItem> getItems() {
		return items;
	}

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
