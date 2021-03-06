package starglas.dsremake.common.MCACommonLibrary.animation;

import starglas.dsremake.common.MCACommonLibrary.math.Quaternion;
import starglas.dsremake.common.MCACommonLibrary.math.Vector3f;

import java.util.HashMap;

public class KeyFrame {
	public HashMap<String, Quaternion> modelRenderersRotations = new HashMap<String, Quaternion>();
	public HashMap<String, Vector3f> modelRenderersTranslations = new HashMap<String, Vector3f>();
	
	public boolean useBoxInRotations(String boxName)
	{
		return modelRenderersRotations.get(boxName) != null;
	}
	
	public boolean useBoxInTranslations(String boxName)
	{
		return modelRenderersTranslations.get(boxName) != null;
	}
}