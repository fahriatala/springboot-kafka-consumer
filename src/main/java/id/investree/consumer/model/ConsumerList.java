package id.investree.consumer.model;

import java.util.ArrayList;
import java.util.List;

public class ConsumerList {

	private List<ConsumerModel> consumerModelList;

	public ConsumerList() {
		consumerModelList = new ArrayList<>();
	}

	public List<ConsumerModel> getConsumerModelList() {
		return consumerModelList;
	}

	public void setConsumerModelList(List<ConsumerModel> consumerModelList) {
		this.consumerModelList = consumerModelList;
	}
}


