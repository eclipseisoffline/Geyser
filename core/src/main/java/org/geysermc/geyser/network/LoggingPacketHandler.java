/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.network;

import org.cloudburstmc.protocol.bedrock.packet.AddBehaviorTreePacket;
import org.cloudburstmc.protocol.bedrock.packet.AddEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.AddHangingEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.AddItemEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.AddPaintingPacket;
import org.cloudburstmc.protocol.bedrock.packet.AddPlayerPacket;
import org.cloudburstmc.protocol.bedrock.packet.AnimateEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.AnimatePacket;
import org.cloudburstmc.protocol.bedrock.packet.AnvilDamagePacket;
import org.cloudburstmc.protocol.bedrock.packet.AutomationClientConnectPacket;
import org.cloudburstmc.protocol.bedrock.packet.AvailableCommandsPacket;
import org.cloudburstmc.protocol.bedrock.packet.AvailableEntityIdentifiersPacket;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacket;
import org.cloudburstmc.protocol.bedrock.packet.BedrockPacketHandler;
import org.cloudburstmc.protocol.bedrock.packet.BiomeDefinitionListPacket;
import org.cloudburstmc.protocol.bedrock.packet.BlockEntityDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.BlockEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.BlockPickRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.BookEditPacket;
import org.cloudburstmc.protocol.bedrock.packet.BossEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.CameraInstructionPacket;
import org.cloudburstmc.protocol.bedrock.packet.CameraPacket;
import org.cloudburstmc.protocol.bedrock.packet.CameraPresetsPacket;
import org.cloudburstmc.protocol.bedrock.packet.CameraShakePacket;
import org.cloudburstmc.protocol.bedrock.packet.ChangeDimensionPacket;
import org.cloudburstmc.protocol.bedrock.packet.ChunkRadiusUpdatedPacket;
import org.cloudburstmc.protocol.bedrock.packet.ClientCacheBlobStatusPacket;
import org.cloudburstmc.protocol.bedrock.packet.ClientCacheMissResponsePacket;
import org.cloudburstmc.protocol.bedrock.packet.ClientCacheStatusPacket;
import org.cloudburstmc.protocol.bedrock.packet.ClientToServerHandshakePacket;
import org.cloudburstmc.protocol.bedrock.packet.ClientboundMapItemDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.CodeBuilderPacket;
import org.cloudburstmc.protocol.bedrock.packet.CommandBlockUpdatePacket;
import org.cloudburstmc.protocol.bedrock.packet.CommandOutputPacket;
import org.cloudburstmc.protocol.bedrock.packet.CommandRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.CompletedUsingItemPacket;
import org.cloudburstmc.protocol.bedrock.packet.ContainerClosePacket;
import org.cloudburstmc.protocol.bedrock.packet.ContainerOpenPacket;
import org.cloudburstmc.protocol.bedrock.packet.ContainerSetDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.CorrectPlayerMovePredictionPacket;
import org.cloudburstmc.protocol.bedrock.packet.CraftingDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.CreativeContentPacket;
import org.cloudburstmc.protocol.bedrock.packet.DebugInfoPacket;
import org.cloudburstmc.protocol.bedrock.packet.DisconnectPacket;
import org.cloudburstmc.protocol.bedrock.packet.EducationSettingsPacket;
import org.cloudburstmc.protocol.bedrock.packet.EmoteListPacket;
import org.cloudburstmc.protocol.bedrock.packet.EmotePacket;
import org.cloudburstmc.protocol.bedrock.packet.EntityEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.EntityPickRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.EventPacket;
import org.cloudburstmc.protocol.bedrock.packet.ExplodePacket;
import org.cloudburstmc.protocol.bedrock.packet.FilterTextPacket;
import org.cloudburstmc.protocol.bedrock.packet.GameRulesChangedPacket;
import org.cloudburstmc.protocol.bedrock.packet.GuiDataPickItemPacket;
import org.cloudburstmc.protocol.bedrock.packet.HurtArmorPacket;
import org.cloudburstmc.protocol.bedrock.packet.InteractPacket;
import org.cloudburstmc.protocol.bedrock.packet.InventoryContentPacket;
import org.cloudburstmc.protocol.bedrock.packet.InventorySlotPacket;
import org.cloudburstmc.protocol.bedrock.packet.InventoryTransactionPacket;
import org.cloudburstmc.protocol.bedrock.packet.ItemComponentPacket;
import org.cloudburstmc.protocol.bedrock.packet.ItemStackRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.ItemStackResponsePacket;
import org.cloudburstmc.protocol.bedrock.packet.LabTablePacket;
import org.cloudburstmc.protocol.bedrock.packet.LecternUpdatePacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelChunkPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventGenericPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEvent1Packet;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEvent2Packet;
import org.cloudburstmc.protocol.bedrock.packet.LevelSoundEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.LoginPacket;
import org.cloudburstmc.protocol.bedrock.packet.MapCreateLockedCopyPacket;
import org.cloudburstmc.protocol.bedrock.packet.MapInfoRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.MobArmorEquipmentPacket;
import org.cloudburstmc.protocol.bedrock.packet.MobEffectPacket;
import org.cloudburstmc.protocol.bedrock.packet.MobEquipmentPacket;
import org.cloudburstmc.protocol.bedrock.packet.ModalFormRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.ModalFormResponsePacket;
import org.cloudburstmc.protocol.bedrock.packet.MotionPredictionHintsPacket;
import org.cloudburstmc.protocol.bedrock.packet.MoveEntityAbsolutePacket;
import org.cloudburstmc.protocol.bedrock.packet.MoveEntityDeltaPacket;
import org.cloudburstmc.protocol.bedrock.packet.MovePlayerPacket;
import org.cloudburstmc.protocol.bedrock.packet.MovementPredictionSyncPacket;
import org.cloudburstmc.protocol.bedrock.packet.MultiplayerSettingsPacket;
import org.cloudburstmc.protocol.bedrock.packet.NetworkChunkPublisherUpdatePacket;
import org.cloudburstmc.protocol.bedrock.packet.NetworkSettingsPacket;
import org.cloudburstmc.protocol.bedrock.packet.NetworkStackLatencyPacket;
import org.cloudburstmc.protocol.bedrock.packet.NpcRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.OnScreenTextureAnimationPacket;
import org.cloudburstmc.protocol.bedrock.packet.PacketViolationWarningPacket;
import org.cloudburstmc.protocol.bedrock.packet.PartyChangedPacket;
import org.cloudburstmc.protocol.bedrock.packet.PhotoTransferPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlaySoundPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayStatusPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerActionPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerArmorDamagePacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerAuthInputPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerEnchantOptionsPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerFogPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerHotbarPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerInputPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerListPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerSkinPacket;
import org.cloudburstmc.protocol.bedrock.packet.PlayerUpdateEntityOverridesPacket;
import org.cloudburstmc.protocol.bedrock.packet.PositionTrackingDBClientRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.PositionTrackingDBServerBroadcastPacket;
import org.cloudburstmc.protocol.bedrock.packet.PurchaseReceiptPacket;
import org.cloudburstmc.protocol.bedrock.packet.RemoveEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.RemoveObjectivePacket;
import org.cloudburstmc.protocol.bedrock.packet.RequestAbilityPacket;
import org.cloudburstmc.protocol.bedrock.packet.RequestChunkRadiusPacket;
import org.cloudburstmc.protocol.bedrock.packet.RequestNetworkSettingsPacket;
import org.cloudburstmc.protocol.bedrock.packet.RequestPermissionsPacket;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackChunkDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackChunkRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackClientResponsePacket;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackDataInfoPacket;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePackStackPacket;
import org.cloudburstmc.protocol.bedrock.packet.ResourcePacksInfoPacket;
import org.cloudburstmc.protocol.bedrock.packet.RespawnPacket;
import org.cloudburstmc.protocol.bedrock.packet.RiderJumpPacket;
import org.cloudburstmc.protocol.bedrock.packet.ServerSettingsRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.ServerSettingsResponsePacket;
import org.cloudburstmc.protocol.bedrock.packet.ServerToClientHandshakePacket;
import org.cloudburstmc.protocol.bedrock.packet.ServerboundDiagnosticsPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetCommandsEnabledPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetDefaultGameTypePacket;
import org.cloudburstmc.protocol.bedrock.packet.SetDifficultyPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetDisplayObjectivePacket;
import org.cloudburstmc.protocol.bedrock.packet.SetEntityDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetEntityLinkPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetEntityMotionPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetHealthPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetLastHurtByPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetLocalPlayerAsInitializedPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetPlayerGameTypePacket;
import org.cloudburstmc.protocol.bedrock.packet.SetPlayerInventoryOptionsPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetScorePacket;
import org.cloudburstmc.protocol.bedrock.packet.SetScoreboardIdentityPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetSpawnPositionPacket;
import org.cloudburstmc.protocol.bedrock.packet.SetTimePacket;
import org.cloudburstmc.protocol.bedrock.packet.SetTitlePacket;
import org.cloudburstmc.protocol.bedrock.packet.SettingsCommandPacket;
import org.cloudburstmc.protocol.bedrock.packet.ShowCreditsPacket;
import org.cloudburstmc.protocol.bedrock.packet.ShowProfilePacket;
import org.cloudburstmc.protocol.bedrock.packet.ShowStoreOfferPacket;
import org.cloudburstmc.protocol.bedrock.packet.SimpleEventPacket;
import org.cloudburstmc.protocol.bedrock.packet.SpawnExperienceOrbPacket;
import org.cloudburstmc.protocol.bedrock.packet.SpawnParticleEffectPacket;
import org.cloudburstmc.protocol.bedrock.packet.StartGamePacket;
import org.cloudburstmc.protocol.bedrock.packet.StopSoundPacket;
import org.cloudburstmc.protocol.bedrock.packet.StructureBlockUpdatePacket;
import org.cloudburstmc.protocol.bedrock.packet.StructureTemplateDataRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.StructureTemplateDataResponsePacket;
import org.cloudburstmc.protocol.bedrock.packet.SubChunkRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.SubClientLoginPacket;
import org.cloudburstmc.protocol.bedrock.packet.TakeItemEntityPacket;
import org.cloudburstmc.protocol.bedrock.packet.TextPacket;
import org.cloudburstmc.protocol.bedrock.packet.TickSyncPacket;
import org.cloudburstmc.protocol.bedrock.packet.ToggleCrafterSlotRequestPacket;
import org.cloudburstmc.protocol.bedrock.packet.TransferPacket;
import org.cloudburstmc.protocol.bedrock.packet.TrimDataPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateAttributesPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateBlockPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateBlockPropertiesPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateBlockSyncedPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateClientOptionsPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateEquipPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdatePlayerGameTypePacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateSoftEnumPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateTradePacket;
import org.cloudburstmc.protocol.bedrock.packet.VideoStreamConnectPacket;
import org.cloudburstmc.protocol.common.PacketSignal;
import org.geysermc.geyser.GeyserImpl;
import org.geysermc.geyser.session.GeyserSession;

/**
 * Bare bones implementation of BedrockPacketHandler suitable for extension.
 * <p>
 * Logs and ignores all packets presented. Allows subclasses to override/implement only
 * packets of interest and limit boilerplate code.
 */
public class LoggingPacketHandler implements BedrockPacketHandler {
    protected final GeyserImpl geyser;
    protected final GeyserSession session;

    LoggingPacketHandler(GeyserImpl geyser, GeyserSession session) {
        this.geyser = geyser;
        this.session = session;
    }

    PacketSignal defaultHandler(BedrockPacket packet) {
        geyser.getLogger().debug("Handled packet: " + packet.getClass().getSimpleName());
        return PacketSignal.HANDLED;
    }

    @Override
    public PacketSignal handle(LoginPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ResourcePackClientResponsePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AnimatePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(BlockEntityDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(BlockPickRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(BookEditPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ClientCacheBlobStatusPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ClientCacheMissResponsePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ClientCacheStatusPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ClientToServerHandshakePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CameraPresetsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CameraInstructionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CommandBlockUpdatePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CommandRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ContainerClosePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(EntityEventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(EntityPickRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(EventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(InteractPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(InventoryContentPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(InventorySlotPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(InventoryTransactionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LabTablePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LecternUpdatePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LevelEventGenericPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LevelSoundEventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MapInfoRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MobArmorEquipmentPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MobEquipmentPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ModalFormResponsePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MoveEntityAbsolutePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MovePlayerPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(NetworkStackLatencyPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PhotoTransferPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerActionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerHotbarPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerInputPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerSkinPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PurchaseReceiptPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(RequestChunkRadiusPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(RequestPermissionsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ResourcePackChunkRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(RiderJumpPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ServerSettingsRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetDefaultGameTypePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetLocalPlayerAsInitializedPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetPlayerGameTypePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SubChunkRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SubClientLoginPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(TextPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AddBehaviorTreePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AddEntityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AddHangingEntityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AddItemEntityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AddPaintingPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AddPlayerPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AvailableCommandsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(BlockEventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(BossEventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CameraPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ChangeDimensionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ChunkRadiusUpdatedPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ClientboundMapItemDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CommandOutputPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ContainerOpenPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ContainerSetDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CraftingDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(DisconnectPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ExplodePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LevelChunkPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(GameRulesChangedPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(GuiDataPickItemPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(HurtArmorPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AutomationClientConnectPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LevelEventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MapCreateLockedCopyPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MobEffectPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ModalFormRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MoveEntityDeltaPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(NpcRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(OnScreenTextureAnimationPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerListPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlaySoundPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayStatusPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(RemoveEntityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(RemoveObjectivePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ResourcePackChunkDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ResourcePackDataInfoPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ResourcePacksInfoPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ResourcePackStackPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(RespawnPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ServerSettingsResponsePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ServerToClientHandshakePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetCommandsEnabledPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetDifficultyPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetDisplayObjectivePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetEntityDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetEntityLinkPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetEntityMotionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetHealthPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetLastHurtByPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetPlayerInventoryOptionsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetScoreboardIdentityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetScorePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetSpawnPositionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetTimePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SetTitlePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ShowCreditsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ShowProfilePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ShowStoreOfferPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SimpleEventPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SpawnExperienceOrbPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(StartGamePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(StopSoundPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(StructureBlockUpdatePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(StructureTemplateDataRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(StructureTemplateDataResponsePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(TakeItemEntityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(TransferPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateAttributesPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateBlockPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateBlockPropertiesPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateBlockSyncedPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateEquipPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateSoftEnumPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateTradePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AvailableEntityIdentifiersPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(BiomeDefinitionListPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LevelSoundEvent2Packet packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(NetworkChunkPublisherUpdatePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SpawnParticleEffectPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(VideoStreamConnectPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(EmotePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(TickSyncPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AnvilDamagePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(NetworkSettingsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerAuthInputPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(SettingsCommandPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(EducationSettingsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CompletedUsingItemPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MultiplayerSettingsPacket packet) {
        return defaultHandler(packet);
    }

    // 1.16 new packets

    @Override
    public PacketSignal handle(DebugInfoPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(EmoteListPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CodeBuilderPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CreativeContentPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ItemStackRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(LevelSoundEvent1Packet packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ItemStackResponsePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerArmorDamagePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerEnchantOptionsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdatePlayerGameTypePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PacketViolationWarningPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PositionTrackingDBClientRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PositionTrackingDBServerBroadcastPacket packet) {
        return defaultHandler(packet);
    }

    // 1.16.100 new packets

    @Override
    public PacketSignal handle(MotionPredictionHintsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(AnimateEntityPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CameraShakePacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerFogPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(CorrectPlayerMovePredictionPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ItemComponentPacket packet) {
        return defaultHandler(packet);
    }

    // 1.16.200 new packet

    @Override
    public PacketSignal handle(FilterTextPacket packet) {
        return defaultHandler(packet);
    }

    // 1.19.0 new packet

    @Override
    public PacketSignal handle(RequestAbilityPacket packet) {
        return defaultHandler(packet);
    }

    // 1.19.30 new packet

    @Override
    public PacketSignal handle(RequestNetworkSettingsPacket packet) {
        return defaultHandler(packet);
    }

    // todo: fix arrangement

    @Override
    public PacketSignal handle(ToggleCrafterSlotRequestPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(TrimDataPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(MovementPredictionSyncPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(ServerboundDiagnosticsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(UpdateClientOptionsPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PlayerUpdateEntityOverridesPacket packet) {
        return defaultHandler(packet);
    }

    @Override
    public PacketSignal handle(PartyChangedPacket packet) {
        return defaultHandler(packet);
    }
}
