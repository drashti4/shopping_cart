package com.isi.shopping.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.isi.shopping.interfaces.IProductListener;

public class ProductPanel extends JPanel implements IProductListener
{
	private static final long serialVersionUID = 1L;
	private static final int DefaultSpace = 10;
	private static final Dimension DefaultSpaceDimension = new Dimension(DefaultSpace, DefaultSpace);
	private static final Dimension HalfSpaceDimension = new Dimension(DefaultSpace / 2, DefaultSpace / 2);
	
	private final JLabel productIdLabel;
	private final JLabel productNameLabel;
	private final JLabel productCategoryLabel;
	private final JLabel productDescriptionLabel;
	private final JLabel productQuantityLabel;
	private final JLabel productPriceLabel;
	private final JLabel productDiscountLabel;
	
	public ProductPanel()
	{
		productIdLabel = new JLabel(" ");
		productNameLabel = new JLabel(" ");
		productCategoryLabel = new JLabel(" ");
		productDescriptionLabel = new JLabel(" ");
		productQuantityLabel = new JLabel(" ");
		productPriceLabel = new JLabel(" ");
		productDiscountLabel = new JLabel(" ");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(
							BorderFactory.createEtchedBorder(),
							BorderFactory.createEmptyBorder(DefaultSpace, DefaultSpace, DefaultSpace, DefaultSpace)));
		this.setAlignmentX(0.5f);
		
		this.add(createHorizontalLabelsPanel("Product #", productIdLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Name", productNameLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Category", productCategoryLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Description", productDescriptionLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Quantity", productQuantityLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Price", productPriceLabel));
		this.add(createHalfSpaceRigidArea());
		this.add(createHorizontalLabelsPanel("Discount", productDiscountLabel));
		
		
	}
	
	private Component createHalfSpaceRigidArea()
	{
		return Box.createRigidArea(HalfSpaceDimension);
	}
	
	private JPanel createHorizontalLabelsPanel(String title, JLabel label)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setAlignmentX(0);
		
		JLabel titleLabel = new JLabel(title);
		
		panel.add(titleLabel);
		panel.add(Box.createRigidArea(DefaultSpaceDimension));
		panel.add(label);
		
		applyFixedWidth(titleLabel, 80);
		applyFixedWidth(label, 200);
		
		return panel;
	}
	private void applyFixedWidth(Component component, int width)
	{
		component.setMinimumSize(new Dimension(width, component.getMinimumSize().height));
		component.setPreferredSize(new Dimension(width, component.getPreferredSize().height));
		component.setMaximumSize(new Dimension(width, component.getMaximumSize().height));
	}
	
	public void updateProductId(Integer productId)
	{
		if (productId != null)
			productIdLabel.setText(Integer.toString(productId));
		else
			productIdLabel.setText(" ");
	}
	public void updateProductName(String productName)
	{
		if (productName != null)
			productNameLabel.setText(productName);
		else
			productIdLabel.setText(" ");
	}
	public void updateProductCategory(String category)
	{
		if (category != null)
			productCategoryLabel.setText(category);
		else
			productCategoryLabel.setText(" ");
	}
	public void updateProductDescription(String description)
	{
		if (description != null)
			productDescriptionLabel.setText(description);
		else
			productDescriptionLabel.setText(" ");
	}
	@Override
	public void updateProductQuantity(Integer quantity)
	{
		if (quantity != null)
			productQuantityLabel.setText(Integer.toString(quantity));
		else
			productQuantityLabel.setText(" ");
	}
	public void updateProductPrice(Double price)
	{
		if (price != null)
			productPriceLabel.setText(Double.toString(price));
		else
			productPriceLabel.setText(" ");
	}
	@Override
	public void updateProductDiscount(Double discount)
	{
		if (discount != null)
			productDiscountLabel.setText(Double.toString(discount));
		else
			productDiscountLabel.setText(" ");
	}
}
