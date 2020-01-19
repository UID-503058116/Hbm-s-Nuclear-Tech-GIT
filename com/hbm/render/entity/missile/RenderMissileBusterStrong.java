package com.hbm.render.entity.missile;

import org.lwjgl.opengl.GL11;

import com.hbm.entity.missile.EntityMissileBusterStrong;
import com.hbm.main.ResourceManager;
import com.hbm.render.RenderHelper;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMissileBusterStrong extends Render<EntityMissileBusterStrong> {
	
	public static final IRenderFactory<EntityMissileBusterStrong> FACTORY = (RenderManager man) -> {return new RenderMissileBusterStrong(man);};
	
	protected RenderMissileBusterStrong(RenderManager renderManager) {
		super(renderManager);
	}
	
	@Override
	public void doRender(EntityMissileBusterStrong missile, double x, double y, double z, float entityYaw, float partialTicks) {
		GL11.glPushMatrix();
        GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
        GL11.glEnable(GL11.GL_LIGHTING);
        double[] renderPos = RenderHelper.getRenderPosFromMissile(missile, partialTicks);
        x = renderPos[0];
        y = renderPos[1];
        z = renderPos[2];
        GL11.glTranslated(x, y, z);
        GL11.glScalef(1.5F, 1.5F, 1.5F);
        GL11.glRotatef(missile.prevRotationYaw + (missile.rotationYaw - missile.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(missile.prevRotationPitch + (missile.rotationPitch - missile.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        
        bindTexture(ResourceManager.missileStrong_BU_tex);
        ResourceManager.missileStrong.renderAll();
        GL11.glPopAttrib();
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMissileBusterStrong entity) {
		return ResourceManager.missileStrong_BU_tex;
	}
}
