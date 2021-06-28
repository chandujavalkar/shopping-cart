package com.shopping.cart.util;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cart.exceptions")
public class ShoppingCartErrorUtil {


		private Map<String, String> error;

		/**
		 * @return the error
		 */
		public Map<String, String> getError() {
			return error;
		}

		/**
		 * @param error the error to set
		 */
		public void setError(Map<String, String> error) {
			this.error = error;
		}
		
	}
