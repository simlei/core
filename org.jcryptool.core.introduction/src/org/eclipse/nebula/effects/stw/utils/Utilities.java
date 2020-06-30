// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2020, 2020 JCrypTool Team and Contributors
 * 
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.eclipse.nebula.effects.stw.utils;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.jcryptool.core.util.colors.ColorService;
import org.jcryptool.core.util.images.ImageService;

/**
 * A utitlity class used to draw elements on the slideshow.
 * @author Thorben Groos
 *
 */
public class Utilities {
	
	/**
	 * Image used to calculate the position of the arrow.
	 */
	private Image _target;
	
	/**
	 * Amount of images in the slideshow.
	 */
	private int _totalImages;
	
	/**
	 * The number of the current image.</br>
	 * Take in note to start counting at 0.
	 */
	private int _curImage;

	/**
	 * 
	 * @param target Image: used for calculating the position of the arrows.
	 * @param totalImages The amount of images in the slideshow.
	 * @param curImage The number of the current image
	 */
	public Utilities(Image target, int totalImages, int curImage) {
		super();
		
		this._target = target;
		this._totalImages = totalImages;
		this._curImage = curImage;
	}
	
	
	/**
	 * Draws the arrow on the left side of the slideshow.
	 * @param e A PaintEvent of the canvas the slideshow is painted on.
	 */
	public void drawLeftArrow(PaintEvent e) {
		Image leftArrow = ImageService.getImage("org.jcryptool.core.introduction", "/images/leftArrow_100.png");
    	ImageData imgData_leftArrow = leftArrow.getImageData();
    	
    	ImageData imgData_toImage = _target.getImageData();
    	
    	int verticalCenter = imgData_toImage.height / 2;
    	int verticalPosition = verticalCenter - (imgData_leftArrow.height / 2);
    	int horizontalPosition = 10;

    	e.gc.setAlpha(180);
    	e.gc.drawImage(leftArrow, horizontalPosition, verticalPosition);
    	e.gc.setAlpha(255);
    	
    	leftArrow.dispose();
	}
	
	/**
	 * Draws the arrow on the right side of the slideshow.
	 * @param e A PaintEvent of the canvas the slideshow is painted on.
	 */
	public void drawRightArrow(PaintEvent e) {
		Image rightArrow = ImageService.getImage("org.jcryptool.core.introduction", "/images/rightArrow_100.png");
    	ImageData imgData_tightArrow = rightArrow.getImageData();
    	
    	ImageData imgData_toImage = _target.getImageData();
    	
    	int verticalCenter = imgData_toImage.height / 2;
    	int verticalPosition = verticalCenter - (imgData_tightArrow.height / 2);
    	int horizontalPosition = imgData_toImage.width - 10 - imgData_tightArrow.width;

    	e.gc.setAlpha(180);
    	e.gc.drawImage(rightArrow, horizontalPosition, verticalPosition);
    	e.gc.setAlpha(255);
    	
    	rightArrow.dispose();
	}
	
	/**
	 * This draws the points at the bottom of the slideshow.</br>
	 * @param e A PaintEvent of the canvas the slideshow is painted on.
	 */
	public void showPosition(PaintEvent e) {
		ImageData imgData_toImage = _target.getImageData();
		
		int horizotalPosition = (imgData_toImage.width / 2) - ((_totalImages * 20) / 2);
		int verticalPosition = imgData_toImage.height - 20;

		e.gc.setAlpha(180);
		e.gc.setBackground(ColorService.GRAY);
		e.gc.fillOval(horizotalPosition + (_curImage * 20) + 5, verticalPosition, 10, 10);
		
		
		e.gc.setForeground(ColorService.GRAY);
		e.gc.setLineWidth(2);
		for (int i = 0; i < _totalImages; i++) {
			e.gc.drawOval(horizotalPosition + (i * 20) + 5, verticalPosition, 10, 10);
		}
		e.gc.setAlpha(255);

	}

}
